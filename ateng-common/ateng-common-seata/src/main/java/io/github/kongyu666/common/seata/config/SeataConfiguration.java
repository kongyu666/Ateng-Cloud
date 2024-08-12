package io.github.kongyu666.common.seata.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * seata 配置
 *
 * @author 孔余
 * @since 2024-06-13 11:05:50
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-seata.yml", factory = YmlPropertySourceFactory.class)
public class SeataConfiguration {

}
