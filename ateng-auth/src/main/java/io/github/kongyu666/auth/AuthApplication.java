package io.github.kongyu666.auth;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDubbo // 启用Dobbo
@EnableDiscoveryClient // 启动Nacos服务发现
@MapperScan("io.github.kongyu666.auth.mapper") // Mybatis-Flex扫描Mapper
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

}
