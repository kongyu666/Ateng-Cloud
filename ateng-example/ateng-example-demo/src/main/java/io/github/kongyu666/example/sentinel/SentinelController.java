package io.github.kongyu666.example.sentinel;

import cn.dev33.satoken.annotation.SaIgnore;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024-06-17 15:04:10
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/test")
    @SaIgnore
    @SentinelResource
    public String test() {
        return "ok";
    }

}
