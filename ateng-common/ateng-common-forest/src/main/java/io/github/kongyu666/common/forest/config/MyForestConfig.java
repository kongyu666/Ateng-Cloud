package io.github.kongyu666.common.forest.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Forest配置文件
 *
 * @author 孔余
 * @since 2024-05-30 14:13
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-forest.yml", factory = YmlPropertySourceFactory.class)
public class MyForestConfig {
}
