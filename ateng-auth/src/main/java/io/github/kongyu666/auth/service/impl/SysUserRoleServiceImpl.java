package io.github.kongyu666.auth.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import io.github.kongyu666.auth.entity.SysUserRole;
import io.github.kongyu666.auth.mapper.SysUserRoleMapper;
import io.github.kongyu666.auth.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现用户与角色之间的多对多关系 服务层实现。
 *
 * @author 孔余
 * @since 1.0.0
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Override
    public void addUserRole(SysUserRole entity) {
        this.save(entity);
    }

    @Override
    public List<SysUserRole> listUserRole() {
        return this.list();
    }

    @Override
    public SysUserRole getUserRole(Integer id) {
        return this.getById(id);
    }
}
