package io.github.kongyu666.auth.service;

import com.mybatisflex.core.service.IService;
import io.github.kongyu666.auth.entity.SysRole;

import java.util.List;

/**
 * 存储系统中的角色信息 服务层。
 *
 * @author 孔余
 * @since 1.0.0
 */
public interface SysRoleService extends IService<SysRole> {
    // 新增
    void addRole(SysRole entity);

    // 查看列表
    List<SysRole> listRole();

    // 查看单个
    SysRole getRole(Integer id);
}
