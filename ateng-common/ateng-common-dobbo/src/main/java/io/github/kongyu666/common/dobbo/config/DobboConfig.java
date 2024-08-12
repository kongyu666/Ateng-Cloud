package io.github.kongyu666.common.dobbo.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Dubbo配置
 * https://sa-token.cc/doc.html#/plugin/dubbo-extend
 *
 * @author 孔余
 * @since 2024-05-31 14:59
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-dobbo.yml", factory = YmlPropertySourceFactory.class)
public class DobboConfig {

}
