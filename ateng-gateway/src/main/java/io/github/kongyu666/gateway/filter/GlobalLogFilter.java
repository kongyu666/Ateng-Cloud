package io.github.kongyu666.gateway.filter;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import io.github.kongyu666.common.core.utils.JsonUtils;
import io.github.kongyu666.gateway.config.properties.ApiDecryptProperties;
import io.github.kongyu666.gateway.config.properties.CustomGatewayProperties;
import io.github.kongyu666.gateway.utils.WebFluxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局日志过滤器
 * <p>
 * 用于打印请求执行参数与响应时间等等
 *
 * @author Lion Li
 */
@Slf4j
@Component
public class GlobalLogFilter implements GlobalFilter, Ordered {

    private static final String START_TIME = "startTime";
    @Autowired
    private CustomGatewayProperties customGatewayProperties;
    @Autowired
    private ApiDecryptProperties apiDecryptProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!customGatewayProperties.getRequestLog()) {
            return chain.filter(exchange);
        }
        ServerHttpRequest request = exchange.getRequest();
        String path = WebFluxUtils.getOriginalRequestUrl(exchange);
        String url = request.getMethod().name() + " " + path;

        // 打印请求参数
        if (WebFluxUtils.isJsonRequest(exchange)) {
            if (apiDecryptProperties.getEnabled()
                    && ObjectUtil.isNotNull(request.getHeaders().getFirst(apiDecryptProperties.getHeaderFlag()))) {
                log.info("[Ateng]开始请求 => URL[{}],参数类型[encrypt]", url);
            } else {
                String jsonParam = WebFluxUtils.resolveBodyFromCacheRequest(exchange);
                log.info("[Ateng]开始请求 => URL[{}],参数类型[json],参数:[{}]", url, jsonParam);
            }
        } else {
            MultiValueMap<String, String> parameterMap = request.getQueryParams();
            if (MapUtil.isNotEmpty(parameterMap)) {
                String parameters = JsonUtils.toJsonString(parameterMap);
                log.info("[Ateng]开始请求 => URL[{}],参数类型[param],参数:[{}]", url, parameters);
            } else {
                log.info("[Ateng]开始请求 => URL[{}],无参数", url);
            }
        }

        exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute(START_TIME);
            if (startTime != null) {
                long executeTime = (System.currentTimeMillis() - startTime);
                log.info("[Ateng]结束请求 => URL[{}],耗时:[{}]毫秒", url, executeTime);
            }
        }));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

}
