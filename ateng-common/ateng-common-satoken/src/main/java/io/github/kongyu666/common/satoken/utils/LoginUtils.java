package io.github.kongyu666.common.satoken.utils;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Assert;
import io.github.kongyu666.common.core.constant.AppCodeEnum;
import io.github.kongyu666.common.core.utils.HttpUtils;
import io.github.kongyu666.common.satoken.model.LoginUser;

import java.util.List;


/**
 * 登录鉴权工具
 *
 * @author 孔余
 * @since 2024-06-03 16:14:37
 */
public class LoginUtils {
    public static final String LOGIN_USER_KEY = "userInfo";


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public static LoginUser login(LoginUser user) {
        // 登录用户
        Assert.isTrue(user.getUserId() != null, AppCodeEnum.AUTH_USER_NOT_FOUND.getDescription());
        String clientType = HttpUtils.getClientType();
        StpUtil.login(user.getUserId(), clientType);
        // 存储权限信息
        List<String> roleList = StpUtil.getRoleList();
        List<String> permissionList = StpUtil.getPermissionList();
        String tokenValue = StpUtil.getTokenValue();
        // 存储到Session
        user.setPassword("******");
        user.setRoleList(roleList);
        user.setPermissionList(permissionList);
        user.setToken(tokenValue);
        SaSession session = StpUtil.getSession();
        session.set(LOGIN_USER_KEY, user);
        return user;
    }

    /**
     * 退出登录
     */
    public static void logout() {
        StpUtil.logout();
    }

    /**
     * 获取用户信息
     */
    public static LoginUser getUserInfo() {
        LoginUser userInfo = StpUtil.getSession().getModel(LOGIN_USER_KEY, LoginUser.class, new LoginUser());
        return userInfo;
    }

}
