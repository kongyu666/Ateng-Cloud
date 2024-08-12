package io.github.kongyu666.common.file.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * 启动X File Storage
 *
 * @author 孔余
 * @since 2024-05-30 15:38
 */
@EnableFileStorage
@AutoConfiguration
@PropertySource(value = "classpath:common-file.yml", factory = YmlPropertySourceFactory.class)
public class EnableXFileStorageConfig {
}
