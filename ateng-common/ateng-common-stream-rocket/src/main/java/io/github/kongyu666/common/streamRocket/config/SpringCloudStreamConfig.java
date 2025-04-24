package io.github.kongyu666.common.streamRocket.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Cloud Stream配置文件
 *
 * @author 孔余
 * @since 2024-06-06 09:37:53
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-stream-rocket.yml", factory = YmlPropertySourceFactory.class)
public class SpringCloudStreamConfig {
}
