package io.github.kongyu666.example;

import com.aizuda.snailjob.client.common.event.SnailClientClosingEvent;
import com.aizuda.snailjob.client.starter.EnableSnailJob;
import io.github.kongyu666.common.core.utils.SpringUtils;
import jakarta.annotation.PreDestroy;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSnailJob(group = "lx_facility") // 启动Snail Job，组名称：lx_facility
//@EnableFeignClients(
//        basePackages = "io.github.kongyu666.api.service", defaultConfiguration = FeignInterceptor.class
//) // 启用Feign实现RPC调用
@EnableDubbo // 启用Dobbo
//@MapperScan("io.github.kongyu666.example.system.mapper") // Mybatis-Flex扫描Mapper
@EnableFileStorage // 启动X File Storage
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setRegisterShutdownHook(true);
        app.run(args);
    }

    @PreDestroy
    public void onExit() {
        // 关闭 Snail Job
        SpringUtils.context().publishEvent(new SnailClientClosingEvent());
        // 处理清理工作，例如关闭数据库连接等
        System.out.println("Application is shutting down...");
    }

}
