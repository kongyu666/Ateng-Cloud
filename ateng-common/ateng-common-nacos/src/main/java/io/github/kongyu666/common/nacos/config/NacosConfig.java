package io.github.kongyu666.common.nacos.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Cloud Alibaba Nacos 配置文件
 *
 * @author Ateng
 * @email 2385569970@qq.com
 * @since 2025-04-21
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-nacos.yml", factory = YmlPropertySourceFactory.class)
public class NacosConfig {
}
