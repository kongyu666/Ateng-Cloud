package io.github.kongyu666.example.cloudStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * 创建消息消费者
 *
 * @author 孔余
 * @since 2024-06-06 09:44:05
 */

@Configuration
public class MessageConsumer {
    /**
     * 注意方法名称 demo 要与配置文件中的spring.cloud.stream.bindings.demo-in-0 保持一致
     * 其中 -in-0 是固定写法，in 标识消费者类型，0是消费者索引
     */
    @Bean
    public Consumer<String> string() {
        return person -> {
            System.out.println("Received: " + person);
        };
    }

    @Bean
    public Consumer<Person> person() {
        return msg -> {
            System.out.println("Received: " + msg);
        };
    }

}
