DROP TABLE IF EXISTS "sys_log_operate";
CREATE TABLE "sys_log_operate" (
                                   "id"              serial PRIMARY KEY,                                -- 自增ID
                                   "username"        varchar(255) COLLATE "pg_catalog"."default",       -- 用户名
                                   "module"          varchar(255) COLLATE "pg_catalog"."default",       -- 模块名
                                   "operation_type"  varchar(100) COLLATE "pg_catalog"."default",       -- 操作类型
                                   "description"     varchar(255) COLLATE "pg_catalog"."default",       -- 操作说明
                                   "class_method"    varchar(255) COLLATE "pg_catalog"."default",       -- 方法全路径
                                   "success"         boolean,                                           -- 请求是否成功
                                   "url"             varchar(255) COLLATE "pg_catalog"."default",       -- 请求的 URL
                                   "method"          varchar(50) COLLATE "pg_catalog"."default",        -- 请求方式（GET/POST 等）
                                   "ip"              varchar(50) COLLATE "pg_catalog"."default",        -- 客户端 IP 地址
                                   "user_agent"      varchar(255) COLLATE "pg_catalog"."default",       -- User-Agent
                                   "params"          text COLLATE "pg_catalog"."default",               -- 请求参数
                                   "headers"         text COLLATE "pg_catalog"."default",               -- 请求头
                                   "body"            text COLLATE "pg_catalog"."default",               -- 请求体
                                   "response"        text COLLATE "pg_catalog"."default",               -- 响应数据
                                   "execution_time"  varchar(50) COLLATE "pg_catalog"."default",        -- 执行耗时（建议改为 int 型）
                                   "exception_message" text COLLATE "pg_catalog"."default",             -- 异常信息
                                   "create_time"     timestamp(6)                                       -- 创建时间
);

COMMENT ON TABLE "sys_log_operate" IS '操作日志记录';

COMMENT ON COLUMN "sys_log_operate"."id" IS '自增ID';
COMMENT ON COLUMN "sys_log_operate"."username" IS '用户名';
COMMENT ON COLUMN "sys_log_operate"."module" IS '模块名';
COMMENT ON COLUMN "sys_log_operate"."operation_type" IS '操作类型';
COMMENT ON COLUMN "sys_log_operate"."description" IS '操作说明';
COMMENT ON COLUMN "sys_log_operate"."class_method" IS '方法全路径（类名+方法名）';
COMMENT ON COLUMN "sys_log_operate"."success" IS '请求是否成功';
COMMENT ON COLUMN "sys_log_operate"."url" IS '请求的 URL';
COMMENT ON COLUMN "sys_log_operate"."method" IS '请求方式';
COMMENT ON COLUMN "sys_log_operate"."ip" IS '客户端 IP 地址';
COMMENT ON COLUMN "sys_log_operate"."user_agent" IS 'User-Agent 请求头';
COMMENT ON COLUMN "sys_log_operate"."params" IS '请求参数（Query 或表单）';
COMMENT ON COLUMN "sys_log_operate"."headers" IS '请求头信息';
COMMENT ON COLUMN "sys_log_operate"."body" IS '请求体（JSON 或表单）';
COMMENT ON COLUMN "sys_log_operate"."response" IS '响应数据';
COMMENT ON COLUMN "sys_log_operate"."execution_time" IS '执行耗时';
COMMENT ON COLUMN "sys_log_operate"."exception_message" IS '异常信息';
COMMENT ON COLUMN "sys_log_operate"."create_time" IS '创建时间';
