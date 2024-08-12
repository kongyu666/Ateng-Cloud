package io.github.kongyu666.common.sms4j.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Sms4j配置
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024-06-18 15:59:35
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-sms4j.yml", factory = YmlPropertySourceFactory.class)
public class MySms4jConfig {
}
