package io.github.kongyu666.common.sentinel.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Sentinel配置
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024-06-17 14:58:44
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-sentinel.yml", factory = YmlPropertySourceFactory.class)
public class MySentinelConfig {
}
