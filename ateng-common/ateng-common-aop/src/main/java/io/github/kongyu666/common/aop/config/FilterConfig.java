package io.github.kongyu666.common.aop.config;

import io.github.kongyu666.common.aop.filter.RepeatableFilter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 过滤器配置类
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @since 2025-02-20
 */
@AutoConfiguration
public class FilterConfig {

    /**
     * 注册一个自定义的 RepeatableFilter，它可以使请求体可重复读取
     * @return
     */
    @Bean
    public FilterRegistrationBean<RepeatableFilter> repeatableFilter() {
        FilterRegistrationBean<RepeatableFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RepeatableFilter());
        registrationBean.addUrlPatterns("/*");  // 设置需要拦截的URL模式
        registrationBean.setName("repeatableFilter");
        registrationBean.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registrationBean;
    }

}
