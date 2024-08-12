package io.github.kongyu666.auth.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import io.github.kongyu666.auth.bo.SysUserLoginBo;
import io.github.kongyu666.auth.bo.SysUserPageBo;
import io.github.kongyu666.auth.entity.SysUser;
import io.github.kongyu666.common.satoken.model.LoginUser;

import java.util.List;

/**
 * 存储用户的基本信息 服务层。
 *
 * @author 孔余
 * @since 1.0.0
 */
public interface SysUserService extends IService<SysUser> {

    // 登录
    LoginUser loginUser(SysUserLoginBo bo);

    // 新增用户
    void addUser(SysUser entity);

    // 分页查询
    Page<SysUser> pageUser(SysUserPageBo bo);

    // 批量删除用户
    void deleteBatchUser(List<Long> ids);

    // 修改用户
    void updateUser(SysUser entity);

    // 根据用户id查询角色列表
    List<String> getUserRoleName(Integer id);

    // 根据用户id查询权限列表
    List<String> getUserPermissionName(Integer id);

}
