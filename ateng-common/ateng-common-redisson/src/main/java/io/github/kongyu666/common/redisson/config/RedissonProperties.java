package io.github.kongyu666.common.redisson.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "redisson")
@AutoConfiguration
@Data
public class RedissonProperties {
    private String config;
}
