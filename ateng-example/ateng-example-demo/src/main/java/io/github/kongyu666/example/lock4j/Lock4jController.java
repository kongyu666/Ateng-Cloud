package io.github.kongyu666.example.lock4j;

import cn.dev33.satoken.annotation.SaIgnore;
import io.github.kongyu666.example.lock4j.entity.User;
import io.github.kongyu666.example.lock4j.service.Lock4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024-06-17 15:04:10
 */
@RestController
@RequestMapping("/lock4j")
public class Lock4jController {
    @Autowired
    private Lock4jService lock4jService;

    @GetMapping("/simple")
    @SaIgnore
    public String simple() {
        lock4jService.simple();
        return "test";
    }

    @PostMapping("/user")
    public User user(@RequestBody User user) {
        User user1 = lock4jService.customMethod(user);
        return user1;
    }
}
