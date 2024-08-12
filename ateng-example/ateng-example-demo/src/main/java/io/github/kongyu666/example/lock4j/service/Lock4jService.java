package io.github.kongyu666.example.lock4j.service;

import com.baomidou.lock.annotation.Lock4j;
import io.github.kongyu666.example.lock4j.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024-06-17 15:04:54
 */
@Service
@Slf4j
public class Lock4jService {

    //默认获取锁超时3秒，30秒锁过期
    @Lock4j
    public void simple() {
        //do something
        log.info("一个分布式锁应用");
    }

    //完全配置，支持spel
    @Lock4j(keys = {"#user.id", "#user.name"}, expire = 60000, acquireTimeout = 1000)
    public User customMethod(User user) {
        return user;
    }
}
