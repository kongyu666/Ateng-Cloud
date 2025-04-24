package io.github.kongyu666.api.service.system;

import io.github.kongyu666.api.model.system.RemoteRequestLogInfo;

/**
 * 操作日志记录 服务层。
 *
 * @author 孔余
 * @since 1.0.0
 */
public interface RemoteRequestLogInfoService {
    // 保存日志
    void logAdd(RemoteRequestLogInfo event);
}
