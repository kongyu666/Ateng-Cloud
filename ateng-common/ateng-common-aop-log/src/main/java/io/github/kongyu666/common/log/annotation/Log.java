package io.github.kongyu666.common.log.annotation;


import io.github.kongyu666.common.core.enums.BusinessType;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @author ruoyi
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    String module() default "";

    /**
     * 操作类型
     */
    String type() default BusinessType.OTHER;

    /**
     * 操作说明
     *
     * @return
     */
    String desc() default "";

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;


    /**
     * 排除指定的请求参数
     */
    String[] excludeParamNames() default {};

}
