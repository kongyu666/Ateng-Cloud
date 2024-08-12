package io.github.kongyu666.common.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import io.github.kongyu666.common.core.factory.YmlPropertySourceFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Jetcache 配置文件
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024-08-02 14:49:02
 */
@AutoConfiguration
@EnableMethodCache(basePackages = "io.github.kongyu666")
@EnableCreateCacheAnnotation
@PropertySource(value = "classpath:common-jetcache.yml", factory = YmlPropertySourceFactory.class)
public class JetcacheConfig {
}
