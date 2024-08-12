package io.github.kongyu666.common.satoken.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 登录用户身份权限
 *
 * @author Lion Li
 */
@Data
@NoArgsConstructor
public class LoginUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String userName;
    private String password;
    private String nickName;
    private String sex;
    private String email;
    private String phoneNumber;
    private Date createTime;
    private Date updateTime;
    /**
     * token
     */
    private String token;
    /**
     * 菜单权限
     */
    private List<String> permissionList;

    /**
     * 角色权限
     */
    private List<String> roleList;

}
