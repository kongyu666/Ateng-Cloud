package io.github.kongyu666.auth.config;


import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import io.github.kongyu666.auth.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义权限加载接口实现类
 *
 * @author 孔余
 * @since 2024-05-23 11:58
 */
@Component    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StpInterfaceImpl implements StpInterface {
    private final SysUserService sysUserService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 缓存到session中
        SaSession session = StpUtil.getSessionByLoginId(loginId);
        return session.get("permissionList", () -> {
            // 从数据库查询这个角色所拥有的权限列表
            List<String> list = sysUserService.getUserPermissionName(Integer.valueOf(loginId.toString()));
            return list;
        });
    }

    /**
     * 如果权限有了变更，重新登录用户就可以刷新
     */

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 缓存到session中
        SaSession session = StpUtil.getSessionByLoginId(loginId);
        return session.get("roleList", () -> {
            // 从数据库查询这个账号id拥有的角色列表
            List<String> list = sysUserService.getUserRoleName(Integer.valueOf(loginId.toString()));
            return list;
        });
    }

}

