package io.github.kongyu666.auth.service;

import com.mybatisflex.core.service.IService;
import io.github.kongyu666.auth.entity.SysUserRole;

import java.util.List;

/**
 * 实现用户与角色之间的多对多关系 服务层。
 *
 * @author 孔余
 * @since 1.0.0
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    // 新增
    void addUserRole(SysUserRole entity);

    // 查看列表
    List<SysUserRole> listUserRole();

    // 查看单个
    SysUserRole getUserRole(Integer id);
}
