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
     * 用户名
     */
    private String username;

    /**
     * 模块名
     */
    private String module;

    /**
     * 操作类型
     */
    private String operationType;

    /**
     * 操作说明
     */
    private String description;

    /**
     * 方法全路径（类名+方法名）
     */
    private String classMethod;

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 请求的 URL
     */
    private String url;

    /**
     * 请求方式（GET、POST、PUT、DELETE 等）
     */
    private String method;

    /**
     * 客户端 IP 地址
     */
    private String ip;

    /**
     * User-Agent 请求头
     */
    private String userAgent;

    /**
     * 请求参数（Query String 或表单参数）
     */
    private String params;

    /**
     * 请求头信息
     */
    private String headers;

    /**
     * 请求体（JSON 或表单）
     */
    private String body;

    /**
     * 响应数据
     */
    private String response;

    /**
     * 执行耗时
     */
    private String executionTime;

    /**
     * 异常信息（如有）
     */
    private String exceptionMessage;

    /**
     * 创建时间
     */
    private Timestamp createTime;

}
