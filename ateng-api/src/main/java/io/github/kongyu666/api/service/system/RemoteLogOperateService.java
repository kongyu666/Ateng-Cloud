package io.github.kongyu666.api.service.system;

import io.github.kongyu666.api.model.RemoteLogOperate;

/**
 * 操作日志记录 服务层。
 *
 * @author 孔余
 * @since 1.0.0
 */
public interface RemoteLogOperateService {
    // 保存日志
    void logAdd(RemoteLogOperate event);
}
