package io.github.kongyu666.common.stomp.config;

import io.github.kongyu666.common.stomp.config.properties.StompProperties;
import io.github.kongyu666.common.stomp.interceptor.AuthHandshakeInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    private final StompProperties stompProperties;

    /**
     * 配置消息代理，用于处理消息传输。
     *
     * @param config 消息代理注册对象
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 启用简单的消息代理，以便在特定目的地前缀下广播消息给连接的客户端
        config.enableSimpleBroker(
                !stompProperties.getBrokerDestinationPrefixes().isEmpty()
                        ? stompProperties.getBrokerDestinationPrefixes().toArray(new String[0])
                        : new String[]{"/topic", "/user"}
        );
        // 设置应用程序的目的地前缀，客户端发送消息时使用的前缀
        config.setApplicationDestinationPrefixes(
                !stompProperties.getApplicationDestinationPrefixes().isEmpty()
                        ? stompProperties.getApplicationDestinationPrefixes().toArray(new String[0])
                        : new String[]{"/app"}
        );
        config.setApplicationDestinationPrefixes("/app");
        // 设置用户目的地前缀，用于处理点对点消息
        config.setUserDestinationPrefix(
                !stompProperties.getUserDestinationPrefix().isBlank()
                        ? stompProperties.getUserDestinationPrefix()
                        : "/user"
        );
    }

    /**
     * 注册STOMP端点，允许客户端连接WebSocket。
     *
     * @param registry STOMP端点注册对象
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        if (stompProperties.getEnabled() && !stompProperties.getEndpoint().isBlank()) {
            registry
                    // 添加STOMP端点，客户端将使用该端点连接WebSocket
                    .addEndpoint(stompProperties.getEndpoint())
                    // 允许来自任何源的跨域请求
                    .setAllowedOriginPatterns(!stompProperties.getAllowedOrigins().isEmpty() ? stompProperties.getAllowedOrigins().toArray(new String[0]) : new String[]{"*"})
                    // 添加拦截器，用于在握手之前进行用户认证
                    .addInterceptors(new AuthHandshakeInterceptor())
                    // 启用SockJS支持，以便客户端在不支持WebSocket的情况下能够使用备用传输方式
                    .withSockJS();
        }
    }

}
