package io.github.kongyu666.auth.dubbo;

import io.github.kongyu666.api.service.DobboTestService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * Dobbo示例：实现服务接口
 *
 * @author 孔余
 * @since 2024-06-07 11:28
 */
@DubboService
public class DobboTestServiceImpl implements DobboTestService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
