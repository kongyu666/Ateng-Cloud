package io.github.kongyu666.common.admin.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Boot Admin配置文件
 *
 * @author 孔余
 * @since 2024-05-30 15:38
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-admin.yml", factory = YmlPropertySourceFactory.class)
public class SpringBootAdminConfig {
}
