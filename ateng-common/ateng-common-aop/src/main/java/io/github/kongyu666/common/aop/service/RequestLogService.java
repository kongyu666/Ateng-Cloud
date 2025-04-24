package io.github.kongyu666.common.aop.service;

import cn.hutool.core.bean.BeanUtil;
import io.github.kongyu666.api.model.system.RemoteRequestLogInfo;
import io.github.kongyu666.api.service.system.RemoteRequestLogInfoService;
import io.github.kongyu666.common.aop.event.RequestLogEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 接受切面发布日志事件的数据
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @since 2025-02-20
 */
@Service
@Slf4j
public class RequestLogService {

    @DubboReference
    private RemoteRequestLogInfoService remoteRequestLogInfoService;

    /**
     * 保存系统日志记录
     */
    @EventListener
    @Async
    public void saveLog(RequestLogEvent requestLogEvent) {
        RemoteRequestLogInfo logInfo = BeanUtil.toBean(requestLogEvent.getRequestLogInfo(), RemoteRequestLogInfo.class);
        remoteRequestLogInfoService.logAdd(logInfo);
    }

}
