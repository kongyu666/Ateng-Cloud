/*
 Navicat Premium Data Transfer

 Source Server         : 本地开发环境PostgreSQL
 Source Server Type    : PostgreSQL
 Source Server Version : 160001 (160001)
 Source Host           : 192.168.1.10:32297
 Source Catalog        : lx_ateng
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 160001 (160001)
 File Encoding         : 65001

 Date: 24/05/2024 16:53:55
*/


-- ----------------------------
-- Table structure for sys_log_operate
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_log_operate";
CREATE TABLE "public"."sys_log_operate"
(
    "id"             serial primary key,
    "user_name"      varchar(255) COLLATE "pg_catalog"."default",
    "module"         varchar(255) COLLATE "pg_catalog"."default",
    "status"         varchar(50) COLLATE "pg_catalog"."default",
    "type"           varchar(50) COLLATE "pg_catalog"."default",
    "describe"       varchar(50) COLLATE "pg_catalog"."default",
    "method"         varchar(255) COLLATE "pg_catalog"."default",
    "request_method" varchar(50) COLLATE "pg_catalog"."default",
    "request_param"  varchar(255) COLLATE "pg_catalog"."default",
    "url"            varchar(255) COLLATE "pg_catalog"."default",
    "json_result"    text COLLATE "pg_catalog"."default",
    "ip"             varchar(50) COLLATE "pg_catalog"."default",
    "cost_time"      int4,
    "error_msg"      text COLLATE "pg_catalog"."default",
    "create_time"    timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_log_operate"."id" IS '自增ID';
COMMENT ON COLUMN "public"."sys_log_operate"."user_name" IS '用户';
COMMENT ON COLUMN "public"."sys_log_operate"."module" IS '模块';
COMMENT ON COLUMN "public"."sys_log_operate"."status" IS '访问状态';
COMMENT ON COLUMN "public"."sys_log_operate"."type" IS '类型';
COMMENT ON COLUMN "public"."sys_log_operate"."describe" IS '描述';
COMMENT ON COLUMN "public"."sys_log_operate"."method" IS '方法';
COMMENT ON COLUMN "public"."sys_log_operate"."request_method" IS '请求方式';
COMMENT ON COLUMN "public"."sys_log_operate"."request_param" IS '请求参数';
COMMENT ON COLUMN "public"."sys_log_operate"."url" IS '请求URI';
COMMENT ON COLUMN "public"."sys_log_operate"."json_result" IS '返回数据';
COMMENT ON COLUMN "public"."sys_log_operate"."ip" IS 'IP';
COMMENT ON COLUMN "public"."sys_log_operate"."cost_time" IS '消耗时间';
COMMENT ON COLUMN "public"."sys_log_operate"."error_msg" IS '错误日志';
COMMENT ON COLUMN "public"."sys_log_operate"."create_time" IS '创建时间';
COMMENT ON TABLE "public"."sys_log_operate" IS '操作日志记录';

-- ----------------------------
-- Records of sys_log_operate
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_permission";
CREATE TABLE "public"."sys_permission"
(
    "permission_id"   serial primary key,
    "permission_name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
    "description"     text COLLATE "pg_catalog"."default",
    "created_time"    timestamp(6) DEFAULT CURRENT_TIMESTAMP,
    "updated_time"    timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_permission"."permission_id" IS '权限ID，主键，自增';
COMMENT ON COLUMN "public"."sys_permission"."permission_name" IS '权限名称';
COMMENT ON COLUMN "public"."sys_permission"."description" IS '权限描述';
COMMENT ON COLUMN "public"."sys_permission"."created_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_permission"."updated_time" IS '更新时间';
COMMENT ON TABLE "public"."sys_permission" IS '存储系统中的权限信息';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO "public"."sys_permission" (permission_name, description, created_time, updated_time)
VALUES ('*', '所有权限', '2024-05-23 17:20:45.380291', NULL),
       ('system.user.add', '系统设置-用户设置-新增', '2024-05-23 17:22:31.758334', NULL),
       ('system.user.get', '系统设置-用户设置-查看', '2024-05-23 17:22:44.678532', NULL),
       ('system.user.delete', '系统设置-用户设置-删除', '2024-05-23 17:24:03.607576', NULL),
       ('system.user.update', '系统设置-用户设置-修改', '2024-05-23 17:24:12.675225', NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role"
(
    "role_id"      serial primary key,
    "role_name"    varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
    "description"  text COLLATE "pg_catalog"."default",
    "created_time" timestamp(6) DEFAULT CURRENT_TIMESTAMP,
    "updated_time" timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_role"."role_id" IS '角色ID，主键，自增';
COMMENT ON COLUMN "public"."sys_role"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."sys_role"."description" IS '角色描述';
COMMENT ON COLUMN "public"."sys_role"."created_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_role"."updated_time" IS '更新时间';
COMMENT ON TABLE "public"."sys_role" IS '存储系统中的角色信息';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "public"."sys_role" (role_name, description, created_time, updated_time)
VALUES ('super-admin', '超级管理员', '2024-05-23 17:19:16.843458', NULL),
       ('admin', '管理员', '2024-05-23 14:46:17.272544', NULL),
       ('user', '普通用户', '2024-05-23 14:46:33.87733', NULL);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_permission";
CREATE TABLE "public"."sys_role_permission"
(
    "role_id"       int4 NOT NULL,
    "permission_id" int4 NOT NULL
)
;
COMMENT ON COLUMN "public"."sys_role_permission"."role_id" IS '角色ID';
COMMENT ON COLUMN "public"."sys_role_permission"."permission_id" IS '权限ID';
COMMENT ON TABLE "public"."sys_role_permission" IS '实现角色与权限之间的多对多关系';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO "public"."sys_role_permission"
VALUES (1, 1);
INSERT INTO "public"."sys_role_permission"
VALUES (2, 2);
INSERT INTO "public"."sys_role_permission"
VALUES (2, 3);
INSERT INTO "public"."sys_role_permission"
VALUES (2, 4);
INSERT INTO "public"."sys_role_permission"
VALUES (2, 5);
INSERT INTO "public"."sys_role_permission"
VALUES (3, 3);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user"
(
    "user_id"      serial primary key,
    "user_name"    varchar(30) COLLATE "pg_catalog"."default"  NOT NULL,
    "nick_name"    varchar(30) COLLATE "pg_catalog"."default"  NOT NULL,
    "password"     varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
    "sex"          varchar(10) COLLATE "pg_catalog"."default",
    "email"        varchar(50) COLLATE "pg_catalog"."default",
    "phone_number" varchar(11) COLLATE "pg_catalog"."default",
    "create_time"  timestamp(6) DEFAULT CURRENT_TIMESTAMP,
    "update_time"  timestamp(6)
)
;
COMMENT ON COLUMN "public"."sys_user"."user_id" IS '用户ID，主键，自增';
COMMENT ON COLUMN "public"."sys_user"."user_name" IS '用户名';
COMMENT ON COLUMN "public"."sys_user"."nick_name" IS '用户昵称';
COMMENT ON COLUMN "public"."sys_user"."password" IS '用户密码（加密后）';
COMMENT ON COLUMN "public"."sys_user"."sex" IS '性别';
COMMENT ON COLUMN "public"."sys_user"."email" IS '用户邮箱';
COMMENT ON COLUMN "public"."sys_user"."phone_number" IS '手机号码';
COMMENT ON COLUMN "public"."sys_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."sys_user"."update_time" IS '修改时间';
COMMENT ON TABLE "public"."sys_user" IS '存储用户的基本信息';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" (user_name, nick_name, password, sex, email, phone_number, create_time, update_time)
VALUES ('ateng', '阿腾', '$2a$10$mSl7i4wOGibcFeF25e.Ra.eY5yi22rXfOwqa5r4mw1p60xfMMNAPe', '男', '2385569970@qq.com', '17623062936',
        '2024-05-24 09:18:04.100225', NULL),
       ('admin', '管理员', '$2a$10$Z2dd/HCSu0KG5FavJph0J.g3J8wVuvIkcO3wyflVu3pSka3ZnJXC.', '男', '', '', '2024-05-24 09:18:21.5771', NULL),
       ('kongyu', '孔余', '$2a$10$KKeMn5w5K9qCIx79uF1.auzNfmtqqJH0Bj2l9SqG5UStL3AlLImx2', '男', '', '', '2024-05-24 09:18:38.670545', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_role";
CREATE TABLE "public"."sys_user_role"
(
    "user_id" int4 NOT NULL,
    "role_id" int4 NOT NULL
)
;
COMMENT ON COLUMN "public"."sys_user_role"."user_id" IS '用户ID';
COMMENT ON COLUMN "public"."sys_user_role"."role_id" IS '角色ID';
COMMENT ON TABLE "public"."sys_user_role" IS '实现用户与角色之间的多对多关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO "public"."sys_user_role"
VALUES (2, 2);
INSERT INTO "public"."sys_user_role"
VALUES (1, 1);
INSERT INTO "public"."sys_user_role"
VALUES (3, 3);

-- ----------------------------
-- Foreign Keys structure for table sys_role_permission
-- ----------------------------
ALTER TABLE "public"."sys_role_permission"
    ADD CONSTRAINT "sys_role_permission_permission_id_fkey" FOREIGN KEY ("permission_id") REFERENCES "public"."sys_permission" ("permission_id") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "public"."sys_role_permission"
    ADD CONSTRAINT "sys_role_permission_role_id_fkey" FOREIGN KEY ("role_id") REFERENCES "public"."sys_role" ("role_id") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table sys_user_role
-- ----------------------------
ALTER TABLE "public"."sys_user_role"
    ADD CONSTRAINT "sys_user_role_role_id_fkey" FOREIGN KEY ("role_id") REFERENCES "public"."sys_role" ("role_id") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "public"."sys_user_role"
    ADD CONSTRAINT "sys_user_role_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."sys_user" ("user_id") ON DELETE CASCADE ON UPDATE NO ACTION;
