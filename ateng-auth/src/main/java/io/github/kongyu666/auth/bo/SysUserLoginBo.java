package io.github.kongyu666.auth.bo;

import io.github.kongyu666.common.core.xss.Xss;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 存储用户的基本信息 实体类。
 *
 * @author 孔余
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserLoginBo implements Serializable {
    @Xss(message = "用户账号不能包含脚本字符")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 1, max = 30, message = "用户账号长度不能超过{max}个字符")
    private String userName;
    @Xss(message = "用户密码不能包含脚本字符")
    @NotBlank(message = "用户密码不能为空")
    private String password;
}
