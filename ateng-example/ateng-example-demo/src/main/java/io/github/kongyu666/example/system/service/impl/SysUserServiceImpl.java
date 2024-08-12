package io.github.kongyu666.example.system.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import io.github.kongyu666.example.system.entity.SysUser;
import io.github.kongyu666.example.system.mapper.SysUserMapper;
import io.github.kongyu666.example.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 存储用户的基本信息 服务层实现。
 *
 * @author 孔余
 * @since 1.0.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
