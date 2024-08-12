package io.github.kongyu666.example.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类的模板注释
 *
 * @author 孔余
 * @since 2024-05-30 15:54
 */
@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class APIController {
    /*private final SpCfgInterface spCfgInterface;

    @GetMapping("/test")
    public Result api() {
        Result roleList = spCfgInterface.getRoleList();
        System.out.println(roleList);
        return roleList;
    }*/

}
