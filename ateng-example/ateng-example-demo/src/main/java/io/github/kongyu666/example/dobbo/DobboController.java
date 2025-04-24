package io.github.kongyu666.example.dobbo;

import io.github.kongyu666.api.service.demo.RemoteDemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的模板注释
 *
 * @author 孔余
 * @since 2024-06-07 11:29
 */
@RestController
@RequestMapping("/dobbo")
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DobboController {

    @DubboReference
    private RemoteDemoService remoteDemoService;

    @GetMapping("/hello")
    public String hello(String name) {
        String result = remoteDemoService.hello(name);
        return result;
//        return "";
    }

}
