package io.github.kongyu666.gateway.handler;

import io.github.kongyu666.common.core.constant.AppCodeEnum;
import io.github.kongyu666.gateway.utils.WebFluxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.resource.NoResourceFoundException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 网关统一异常处理
 *
 * @author ruoyi
 */
@Slf4j
@Order(-1)
@Configuration
public class GatewayExceptionHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ex.printStackTrace();
        ServerHttpResponse response = exchange.getResponse();

        if (exchange.getResponse().isCommitted()) {
            return Mono.error(ex);
        }

        String msg;
        String code = "-1";

        if (ex instanceof NotFoundException) {
            msg = AppCodeEnum.SERVICE_UNAVAILABLE.getDescription();
            code = AppCodeEnum.SERVICE_UNAVAILABLE.getCode();
        } else if (ex instanceof NoResourceFoundException) {
            msg = AppCodeEnum.RESOURCE_NOT_FOUND.getDescription();
            code = AppCodeEnum.RESOURCE_NOT_FOUND.getCode();
        } else if (ex instanceof ResponseStatusException responseStatusException) {
            msg = responseStatusException.getMessage();
        } else {
            msg = AppCodeEnum.ERROR.getDescription();
            code = AppCodeEnum.ERROR.getCode();
        }

        log.error("[网关异常处理]请求路径:{},异常信息:{}", exchange.getRequest().getPath(), ex.getMessage());

        return WebFluxUtils.webFluxResponseWriter(response, msg, code);
    }
}
