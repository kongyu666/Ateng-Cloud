package io.github.kongyu666.common.web.config;

import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.PropertySource;

/**
 * undertow 配置
 *
 * @author 孔余
 * @since 2024-05-30 14:13
 */
@AutoConfiguration
@PropertySource(value = "classpath:common-web.yml", factory = YmlPropertySourceFactory.class)
public class MyUndertowConfig implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    /**
     * 设置 Undertow 的 websocket 缓冲池
     */
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        // 默认不直接分配内存 如果项目中使用了 websocket 建议直接分配
        factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
            webSocketDeploymentInfo.setBuffers(new DefaultByteBufferPool(false, 512));
            deploymentInfo.addServletContextAttribute("io.undertow.websockets.jsr.WebSocketDeploymentInfo", webSocketDeploymentInfo);
        });
    }
}
