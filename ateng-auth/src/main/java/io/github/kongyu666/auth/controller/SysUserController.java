package io.github.kongyu666.auth.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.paginate.Page;
import io.github.kongyu666.auth.bo.SysUserLoginBo;
import io.github.kongyu666.auth.bo.SysUserPageBo;
import io.github.kongyu666.auth.entity.SysUser;
import io.github.kongyu666.auth.service.SysUserService;
import io.github.kongyu666.common.core.enums.BusinessType;
import io.github.kongyu666.common.core.utils.Result;
import io.github.kongyu666.common.core.validation.AddGroup;
import io.github.kongyu666.common.core.validation.UpdateGroup;
import io.github.kongyu666.common.log.annotation.Log;
import io.github.kongyu666.common.satoken.model.LoginUser;
import io.github.kongyu666.common.satoken.utils.LoginUtils;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 认证权限管理/用户设置
 *
 * @author 孔余
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class SysUserController {

    private final SysUserService sysUserService;

    /**
     * 登录
     */
    @PostMapping("/login")
    @SaIgnore
    public Result login(@Validated @RequestBody SysUserLoginBo bo) {
        LoginUser loginUser = sysUserService.loginUser(bo);
        return Result.success(loginUser);
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout")
    public Result logout() {
        StpUtil.logout();
        return Result.success();
    }

    /**
     * 新增
     */
    @Log(module = "用户设置", desc = "新增用户", type = BusinessType.ADD)
    @SaCheckRole("admin")
    @SaCheckPermission("system.user.add")
    @PostMapping("/add")
    public Result add(@Validated(AddGroup.class) @RequestBody SysUser entity) {
        sysUserService.addUser(entity);
        return Result.success();
    }

    /**
     * 查询所有
     */
    @SaCheckPermission(value = "system.user.get", orRole = "admin")
    @GetMapping("/list")
    public Result list() {
        List<SysUser> list = sysUserService.list();
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @SaCheckPermission(value = "system.user.get", orRole = "admin")
    @PostMapping("/page")
    public Result page(@Validated @RequestBody SysUserPageBo bo) {
        Page<SysUser> sysUserPage = sysUserService.pageUser(bo);
        return Result.success(sysUserPage);
    }

    /**
     * 批量删除
     */
    @Log(module = "用户设置", desc = "删除用户", type = BusinessType.DELETE)
    @SaCheckRole("admin")
    @SaCheckPermission("system.user.delete")
    @PostMapping("/delete-batch")
    public Result deleteBatch(
            @Validated @RequestBody
            @Size(min = 1, message = "id列表不能为空")
            List<Long> ids
    ) {
        sysUserService.deleteBatchUser(ids);
        return Result.success();
    }

    /**
     * 更新
     */
    @Log(module = "用户设置", desc = "更新用户", type = BusinessType.UPDATE)
    @SaCheckRole("admin")
    @SaCheckPermission("system.user.update")
    @PostMapping("/update")
    public Result update(@Validated(UpdateGroup.class) @RequestBody SysUser entity) {
        sysUserService.updateUser(entity);
        return Result.success();
    }

    /**
     * 获取详细信息
     */
    @SaCheckPermission(value = "system.user.get", orRole = "admin")
    @GetMapping("/get")
    public Result get(
            @NotNull(message = "id不能为空")
            @Min(value = 1, message = "id不正确")
            Integer id
    ) {
        SysUser sysUser = sysUserService.getById(id);
        return Result.success(sysUser);
    }

    /**
     * 获取账号权限
     */
    @GetMapping("/get-permission-list")
    public Result getPermissionList() {
        List<String> permissionList = StpUtil.getPermissionList();
        return Result.success(permissionList);
    }

    /**
     * 获取账号角色
     */
    @GetMapping("/get-role-list")
    public Result getRoleList() {
        List<String> roleList = StpUtil.getRoleList();
        return Result.success(roleList);
    }

    /**
     * 获取用户信息
     */
    @GetMapping("/user-info")
    public Result getUserInfo() {
        LoginUser userInfo = LoginUtils.getUserInfo();
        return Result.success(userInfo);
    }

}
