package io.github.kongyu666.example.cloudStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的模板注释
 *
 * @author 孔余
 * @since 2024-06-06 09:52
 */
@RestController
@RequestMapping("/message")
public class MessageController {
  /*  @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/send")
    public void send() {
        messageProducer.sendSimpleMessage(new Person("阿腾", 24));
    }

    @GetMapping("/send2")
    public void send2() {
        messageProducer.sendCustomizeMessage(IdUtil.nanoId());
    }*/
}
