package io.github.kongyu666.system.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志设置
 *
 * @author 孔余
 * @since 1.0.0
 */
@RestController
@RequestMapping("/log")
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class SysLogOperateController {


}
