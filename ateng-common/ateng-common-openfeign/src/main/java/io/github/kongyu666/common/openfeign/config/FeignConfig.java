package io.github.kongyu666.common.openfeign.config;

import feign.Retryer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * OpenFeign重试机制
 *
 * @author 孔余
 * @since 2024-06-05 15:12
 */
@AutoConfiguration
public class FeignConfig {
    @Bean
    public Retryer myRetryer() {
//        return Retryer.NEVER_RETRY;//Feign默认是不走重试策略订单

//         最大请求次数为3（1+2），初识间隔时间为100ms，重试最大间隔是1s
        return new Retryer.Default(100, 1, 3);
    }
}