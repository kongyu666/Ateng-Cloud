package io.github.kongyu666.auth.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import io.github.kongyu666.auth.entity.SysPermission;
import io.github.kongyu666.auth.service.SysPermissionService;
import io.github.kongyu666.common.core.enums.BusinessType;
import io.github.kongyu666.common.core.utils.Result;
import io.github.kongyu666.common.log.annotation.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 认证权限管理/权限设置
 *
 * @author 孔余
 * @since 1.0.0
 */
@RestController
@RequestMapping("/permission")
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SaCheckRole("super-admin")
public class SysPermissionController {

    private final SysPermissionService sysPermissionService;

    /**
     * 新增
     */
    @Log(module = "权限设置", desc = "权限角色", type = BusinessType.ADD)
    @PostMapping("/add")
    public Result add(@RequestBody SysPermission entity) {
        sysPermissionService.addRole(entity);
        return Result.success();
    }

    /**
     * 查看列表
     */
    @GetMapping("/list")
    public Result list() {
        List<SysPermission> list = sysPermissionService.listPermission();
        return Result.success(list);
    }

    /**
     * 查看单个
     */
    @GetMapping("/get")
    public Result get(Integer id) {
        SysPermission permission = sysPermissionService.getPermission(id);
        return Result.success(permission);
    }
}
