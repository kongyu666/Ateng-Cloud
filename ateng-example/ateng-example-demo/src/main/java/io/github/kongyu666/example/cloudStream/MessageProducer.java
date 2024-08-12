package io.github.kongyu666.example.cloudStream;


import org.springframework.stereotype.Service;

/**
 * 创建消息生产者
 *
 * @author 孔余
 * @since 2024-06-06 09:43:51
 */

@Service
public class MessageProducer {
/*
    @Autowired
    private StreamBridge streamBridge;

    public void sendSimpleMessage(Person person) {
        streamBridge.send("person-out-0", MessageBuilder.withPayload(person).build());
    }

    public void sendCustomizeMessage(String payload) {
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.KEY, IdUtil.simpleUUID().getBytes())
                .build();
        streamBridge.send("string-out-0", message);
    }*/
}

