package io.github.kongyu666.auth.service;

import com.mybatisflex.core.service.IService;
import io.github.kongyu666.auth.entity.SysRolePermission;

import java.util.List;

/**
 * 实现角色与权限之间的多对多关系 服务层。
 *
 * @author 孔余
 * @since 1.0.0
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {
    // 新增
    void addRolePermission(SysRolePermission entity);

    // 查看列表
    List<SysRolePermission> listRolePermission();

    // 查看单个
    SysRolePermission getRolePermission(Integer id);
}
