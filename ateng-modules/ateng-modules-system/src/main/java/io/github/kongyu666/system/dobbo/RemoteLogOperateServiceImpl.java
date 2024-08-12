package io.github.kongyu666.system.dobbo;

import cn.hutool.core.bean.BeanUtil;
import io.github.kongyu666.api.model.RemoteLogOperate;
import io.github.kongyu666.api.service.system.RemoteLogOperateService;
import io.github.kongyu666.system.entity.SysLogOperate;
import io.github.kongyu666.system.service.SysLogOperateService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

/**
 * Dobbo：实现AOP日志服务接口
 *
 * @author 孔余
 * @since 2024-06-07 15:27
 */
@DubboService
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RemoteLogOperateServiceImpl implements RemoteLogOperateService {

    private final SysLogOperateService sysLogOperateService;

    @Override
    @Async
    public void logAdd(RemoteLogOperate event) {
        SysLogOperate entity = BeanUtil.toBean(event, SysLogOperate.class);
        sysLogOperateService.logAdd(entity);
    }
}
