package io.github.kongyu666.example.system.controller;

import com.mybatisflex.core.paginate.Page;
import io.github.kongyu666.example.system.entity.SysUser;
import io.github.kongyu666.example.system.service.SysUserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 存储用户的基本信息 控制层。
 *
 * @author 孔余
 * @since 1.0.0
 */
@RestController
@RequestMapping("/demo/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 添加存储用户的基本信息。
     *
     * @param sysUser 存储用户的基本信息
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @GlobalTransactional
    public boolean save(@RequestBody SysUser sysUser) {
        return sysUserService.save(sysUser);
    }

    @PostMapping("saveList")
    public List<SysUser> saveList(@RequestBody List<SysUser> list) {
        return list;
    }

    /**
     * 根据主键删除存储用户的基本信息。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public boolean remove(@PathVariable Serializable id) {
        return sysUserService.removeById(id);
    }

    /**
     * 根据主键更新存储用户的基本信息。
     *
     * @param sysUser 存储用户的基本信息
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public boolean update(@RequestBody SysUser sysUser) {
        return sysUserService.updateById(sysUser);
    }

    /**
     * 查询所有存储用户的基本信息。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public List<SysUser> list() {
        return sysUserService.list();
    }

    /**
     * 根据存储用户的基本信息主键获取详细信息。
     *
     * @param id 存储用户的基本信息主键
     * @return 存储用户的基本信息详情
     */
    @GetMapping("getInfo/{id}")
    public SysUser getInfo(@PathVariable Serializable id) {
        return sysUserService.getById(id);
    }

    /**
     * 分页查询存储用户的基本信息。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public Page<SysUser> page(Page<SysUser> page) {
        return sysUserService.page(page);
    }

}
