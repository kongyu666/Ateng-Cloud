package io.github.kongyu666.common.websocket.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * WebSocket 配置
 *
 * @author Ateng
 * @email 2385569970@qq.com
 * @since 2025-04-23
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "websocket")
public class WebSocketProperties {

    /**
     * 开关
     */
    private Boolean enabled;

    /**
     * 路径
     */
    private List<String> paths;

    /**
     * 允许访问的源地址
     */
    private List<String> allowedOrigins;
}
