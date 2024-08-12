package io.github.kongyu666.common.snailjob.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * 启动服务
 *
 * @author 孔余
 * @since 2024-05-27 11:55
 */
@AutoConfiguration
@PropertySource(value = "common-snail-job.yml", factory = YmlPropertySourceFactory.class)
public class SnailJobConfig {
}
