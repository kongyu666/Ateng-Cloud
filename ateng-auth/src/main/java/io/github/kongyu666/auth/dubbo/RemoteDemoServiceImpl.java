package io.github.kongyu666.auth.dubbo;

import io.github.kongyu666.api.service.demo.RemoteDemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * Dobbo示例：实现服务接口
 *
 * @author Ateng
 * @email 2385569970@qq.com
 * @since 2025-04-23
 */
@DubboService
public class RemoteDemoServiceImpl implements RemoteDemoService {

    @Override
    public String hello(String str) {
        return "Hello, " + str;
    }

}
