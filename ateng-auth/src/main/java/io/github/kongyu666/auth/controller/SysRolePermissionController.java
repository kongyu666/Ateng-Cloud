package io.github.kongyu666.auth.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import io.github.kongyu666.auth.entity.SysRolePermission;
import io.github.kongyu666.auth.service.SysRolePermissionService;
import io.github.kongyu666.common.core.enums.BusinessType;
import io.github.kongyu666.common.core.utils.Result;
import io.github.kongyu666.common.log.annotation.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 认证权限管理/角色权限设置
 *
 * @author 孔余
 * @since 1.0.0
 */
@RestController
@RequestMapping("/role-permission")
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SaCheckRole("super-admin")
public class SysRolePermissionController {

    private final SysRolePermissionService sysRolePermissionService;

    /**
     * 新增
     */
    @Log(module = "角色权限设置", desc = "新增角色权限", type = BusinessType.ADD)
    @PostMapping("/add")
    public Result add(@RequestBody SysRolePermission entity) {
        sysRolePermissionService.addRolePermission(entity);
        return Result.success();
    }

    /**
     * 查看列表
     */
    @GetMapping("/list")
    public Result list() {
        List<SysRolePermission> list = sysRolePermissionService.listRolePermission();
        return Result.success(list);
    }

    /**
     * 查看单个
     */
    @GetMapping("/get")
    public Result get(Integer id) {
        SysRolePermission rolePermission = sysRolePermissionService.getRolePermission(id);
        return Result.success(rolePermission);
    }
}
