package io.github.kongyu666.common.websocket.config;

import io.github.kongyu666.common.websocket.config.properties.WebSocketProperties;
import io.github.kongyu666.common.websocket.handler.MyWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebSocketConfig implements WebSocketConfigurer {
    private final MyWebSocketHandler myWebSocketHandler;
    private final WebSocketProperties webSocketProperties;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        if (webSocketProperties.getEnabled() && !webSocketProperties.getPaths().isEmpty()) {
            registry.addHandler(myWebSocketHandler, webSocketProperties.getPaths().toArray(new String[0])).setAllowedOrigins(!webSocketProperties.getAllowedOrigins().isEmpty() ? webSocketProperties.getAllowedOrigins().toArray(new String[0]) : new String[]{"*"});
        }
    }

}
