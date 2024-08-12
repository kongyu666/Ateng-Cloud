package io.github.kongyu666.common.websocket.config;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HandshakeInterceptor用于在WebSocket连接建立之前进行用户认证。
 * 该示例代码展示了如何在WebSocket连接建立之前进行简单的token认证。
 * <p>
 * 作者：孔余
 * 日期：2024-05-11 20:56
 */
@Component
public class WebsocketAuthHandshakeInterceptor implements HandshakeInterceptor {
    private static final Pattern TOKEN_PATTERN = Pattern.compile("token=([^&]+)");

    /**
     * 在握手之前调用，用于用户认证。
     *
     * @param request    当前的HTTP请求
     * @param response   当前的HTTP响应
     * @param wsHandler  将要处理WebSocket消息的处理器
     * @param attributes 将传递给WebSocket会话的属性
     * @return 是否同意握手，true表示同意，false表示拒绝
     * @throws Exception 如果发生错误
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        String token = extractToken(request);

        // 如果token为空，则拒绝握手
        if (token == null || !authenticateUser(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return false;
        }

        // 将token放入attributes中，供WebSocket处理器使用
        attributes.put("token", token);

        return true;
    }

    /**
     * 在握手之后调用。
     *
     * @param request   当前的HTTP请求
     * @param response  当前的HTTP响应
     * @param wsHandler 将要处理WebSocket消息的处理器
     * @param exception 握手过程中发生的异常
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception exception) {
        // 握手成功后的处理，可以在此处进行日志记录或其他操作
    }

    /**
     * 提取请求中的token
     *
     * @param request the ServerHttpRequest
     * @return the token if present, otherwise null
     */
    private String extractToken(ServerHttpRequest request) {
        // 从URI查询参数中提取tokenrequest = {ServletServerHttpRequest@12273}
        String query = request.getURI().getQuery();
        if (query != null) {
            Matcher matcher = TOKEN_PATTERN.matcher(query);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }

        // 尝试从请求头中提取token
        List<String> authHeaders = request.getHeaders().get("Authorization");
        if (authHeaders != null && !authHeaders.isEmpty()) {
            // 假设token是以 "Bearer " 开头
            String authHeader = authHeaders.get(0);
            if (authHeader.startsWith("Bearer ")) {
                return authHeader.substring(7);
            }
        }

        return null;
    }

    /**
     * 验证用户token的有效性
     *
     * @param token the token to authenticate
     * @return true if the token is valid, otherwise false
     */
    private boolean authenticateUser(String token) {
        Object isLogin = StpUtil.getLoginIdByToken(token);
        if (isLogin == null) {
            return false;
        }
        return true;
    }

}
