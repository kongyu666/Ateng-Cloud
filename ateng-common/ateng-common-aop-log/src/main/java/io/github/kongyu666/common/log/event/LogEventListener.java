package io.github.kongyu666.common.log.event;

import cn.hutool.core.bean.BeanUtil;
import io.github.kongyu666.api.model.RemoteLogOperate;
import io.github.kongyu666.api.service.system.RemoteLogOperateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 异步调用日志服务
 *
 * @author ruoyi
 */
@Component
@Slf4j
public class LogEventListener {

    @DubboReference
    private RemoteLogOperateService remoteLogOperateService;

    /**
     * 保存系统日志记录
     */
    @EventListener
    public void saveLog(LogOperateEvent logOperateEvent) {
        RemoteLogOperate remoteLogOperate = BeanUtil.toBean(logOperateEvent, RemoteLogOperate.class);
        remoteLogOperateService.logAdd(remoteLogOperate);
    }

}
