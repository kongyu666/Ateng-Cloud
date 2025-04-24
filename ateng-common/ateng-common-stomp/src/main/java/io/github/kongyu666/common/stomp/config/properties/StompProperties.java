package io.github.kongyu666.common.stomp.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * STOMP 配置
 *
 * @author Ateng
 * @email 2385569970@qq.com
 * @since 2025-04-23
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "stomp")
public class StompProperties {

    /**
     * 开关
     */
    private Boolean enabled;

    /**
     * 允许访问的源地址
     */
    private List<String> allowedOrigins;

    /**
     * 端点
     */
    private String endpoint;

    /**
     * 用户目的地前缀
     */
    private String userDestinationPrefix;

    /**
     * 应用程序的目的地前缀
     */
    private List<String> applicationDestinationPrefixes;

    /**
     * 广播消息给连接的客户端前缀
     */
    private List<String> brokerDestinationPrefixes;

}
