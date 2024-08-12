package io.github.kongyu666.system.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 操作日志记录 实体类。
 *
 * @author 孔余
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sys_log_operate")
public class SysLogOperate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 用户
     */
    private String userName;

    /**
     * 模块
     */
    private String module;

    /**
     * 访问状态
     */
    private String status;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String describe;

    /**
     * 方法
     */
    private String method;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 请求URI
     */
    private String url;

    /**
     * 返回数据
     */
    private String jsonResult;

    /**
     * IP
     */
    private String ip;

    /**
     * 消耗时间
     */
    private Integer costTime;

    /**
     * 错误日志
     */
    private String errorMsg;

    /**
     * 创建时间
     */
    private Timestamp createTime;

}
