package io.github.kongyu666.system.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import io.github.kongyu666.system.entity.SysLogOperate;
import io.github.kongyu666.system.mapper.SysLogOperateMapper;
import io.github.kongyu666.system.service.SysLogOperateService;
import org.springframework.stereotype.Service;

/**
 * 操作日志记录 服务层实现。
 *
 * @author 孔余
 * @since 1.0.0
 */
@Service
public class SysLogOperateServiceImpl extends ServiceImpl<SysLogOperateMapper, SysLogOperate> implements SysLogOperateService {

    @Override
    public void logAdd(SysLogOperate entity) {
        this.save(entity);
    }

}
