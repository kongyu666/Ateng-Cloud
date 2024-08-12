package io.github.kongyu666.auth.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import io.github.kongyu666.auth.entity.SysUserRole;
import io.github.kongyu666.auth.service.SysUserRoleService;
import io.github.kongyu666.common.core.enums.BusinessType;
import io.github.kongyu666.common.core.utils.Result;
import io.github.kongyu666.common.log.annotation.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 认证权限管理/用户角色设置
 *
 * @author 孔余
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user-role")
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SaCheckRole("super-admin")
public class SysUserRoleController {

    private final SysUserRoleService sysUserRoleService;

    /**
     * 新增
     */
    @Log(module = "用户角色设置", desc = "新增用户角色", type = BusinessType.ADD)
    @PostMapping("/add")
    public Result add(@RequestBody SysUserRole entity) {
        sysUserRoleService.addUserRole(entity);
        return Result.success();
    }

    /**
     * 查看列表
     */
    @GetMapping("/list")
    public Result list() {
        List<SysUserRole> list = sysUserRoleService.listUserRole();
        return Result.success(list);
    }

    /**
     * 查看单个
     */
    @GetMapping("/get")
    public Result get(Integer id) {
        SysUserRole userRole = sysUserRoleService.getUserRole(id);
        return Result.success(userRole);
    }
}
