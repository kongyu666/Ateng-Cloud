package io.github.kongyu666.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024/6/17 上午10:38
 * @description 根据请求的IP地址进行限流
 */
@Configuration
public class RedisRateLimiterConfig {
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
