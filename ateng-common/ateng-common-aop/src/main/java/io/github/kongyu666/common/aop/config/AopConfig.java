package io.github.kongyu666.common.aop.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * 启动AOP注解代理访问
 *
 * @author Ateng
 * @email 2385569970@qq.com
 * @since 2025-04-23
 */
@AutoConfiguration
// 表示通过aop框架暴露该代理对象,AopContext能够访问
@EnableAspectJAutoProxy(exposeProxy = true)
@PropertySource(value = "classpath:common-aop.yml", factory = YmlPropertySourceFactory.class)
public class AopConfig {

}
