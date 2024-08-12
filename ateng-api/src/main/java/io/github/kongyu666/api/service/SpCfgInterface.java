package io.github.kongyu666.api.service;

import io.github.kongyu666.common.core.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 服务调用
 */
//@FeignClient(name = "facility-auth", contextId = "SpCfgInterface")
public interface SpCfgInterface {

    // 获取server端指定配置信息
    @GetMapping("/user/get-role-list")
    Result getRoleList();

}

