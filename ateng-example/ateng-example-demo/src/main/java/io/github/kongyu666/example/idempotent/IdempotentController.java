package io.github.kongyu666.example.idempotent;

import cn.dev33.satoken.annotation.SaIgnore;
import io.github.kongyu666.common.idempotent.annotation.RepeatSubmit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024/6/17 上午9:35
 * @description
 */
@RestController
@RequestMapping("/idempotent")
public class IdempotentController {

    @RepeatSubmit
    @GetMapping("/test")
    public String test() {
        return "ok";
    }

    @SaIgnore
    @GetMapping("/test2")
    public String test2() {
        return "ok";
    }
}
