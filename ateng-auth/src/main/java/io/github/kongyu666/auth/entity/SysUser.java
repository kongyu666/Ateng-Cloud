package io.github.kongyu666.auth.entity;

import com.mybatisflex.annotation.ColumnMask;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.mask.Masks;
import io.github.kongyu666.common.core.validation.AddGroup;
import io.github.kongyu666.common.core.validation.UpdateGroup;
import io.github.kongyu666.common.core.xss.Xss;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户信息 实体类。
 *
 * @author 孔余
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sys_user")
public class SysUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，主键，自增
     */
    @Id(keyType = KeyType.Auto)
    @NotNull(message = "用户ID不能为空", groups = {UpdateGroup.class})
    @Min(value = 1, message = "用户ID不正确", groups = {UpdateGroup.class})
    private Integer userId;

    /**
     * 用户名
     */
    @Xss(message = "用户名不能包含脚本字符", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Size(min = 0, max = 30, message = "用户名长度不能超过{max}个字符", groups = {AddGroup.class, UpdateGroup.class})
    private String userName;

    /**
     * 用户昵称
     */
    @Xss(message = "用户昵称不能包含脚本字符", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "用户昵称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过{max}个字符", groups = {AddGroup.class, UpdateGroup.class})
    private String nickName;

    /**
     * 用户密码（加密后）
     */
    @Xss(message = "用户密码不能包含脚本字符", groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "用户密码不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Size(min = 0, max = 30, message = "用户密码长度不能超过{max}个字符", groups = {AddGroup.class, UpdateGroup.class})
    @ColumnMask(Masks.PASSWORD)
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 用户邮箱
     */
    @ColumnMask(Masks.EMAIL)
    private String email;

    /**
     * 手机号码
     */
    @ColumnMask(Masks.MOBILE)
    private String phoneNumber;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

}
