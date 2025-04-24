package io.github.kongyu666.gateway.filter;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.httpauth.basic.SaHttpBasicUtil;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.same.SaSameUtil;
import io.github.kongyu666.common.core.constant.AppCodeEnum;
import io.github.kongyu666.common.core.utils.JsonUtils;
import io.github.kongyu666.common.core.utils.Result;
import io.github.kongyu666.common.core.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器，为请求添加 Same-Token
 *
 * @author 孔余
 * @since 2024-05-30 09:51
 */
@Component
@Slf4j
public class ForwardAuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 未开启配置则直接跳过
        if (!SaManager.getConfig().getCheckSameToken()) {
            return chain.filter(exchange);
        }
        ServerHttpRequest newRequest = exchange
                .getRequest()
                .mutate()
                // 为请求追加 Same-Token 参数
                .header(SaSameUtil.SAME_TOKEN, SaSameUtil.getToken())
                .build();
        ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
        return chain.filter(newExchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }

    /**
     * 对 actuator 健康检查接口 做账号密码鉴权
     */
    @Bean
    public SaReactorFilter getSaServletFilter() {
        String username = SpringUtils.getProperty("spring.cloud.nacos.username");
        String password = SpringUtils.getProperty("spring.cloud.nacos.password");
        return new SaReactorFilter()
                .addInclude("/actuator", "/actuator/**")
                .setAuth(obj -> {
                    // 对 /actuator/shutdown 接口做基础鉴权
                    SaRouter
                            .match("/actuator/shutdown")
                            .check(() -> SaHttpBasicUtil.check(username + ":" + password));
                })
                .setError(e -> {
                    log.error(e.getMessage());
                    return JsonUtils.toJsonString(Result.failure(AppCodeEnum.OPERATION_CANCELED.getCode(), AppCodeEnum.OPERATION_CANCELED.getDescription()).withData("需要基础认证"));
                });
    }

}
