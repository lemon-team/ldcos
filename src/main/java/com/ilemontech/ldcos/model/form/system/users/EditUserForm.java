package com.ilemontech.ldcos.model.form.system.users;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 添加用户表单
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/31 下午4:48
 * @since 1.0 Created by lipangeng on 2017/5/31 下午4:48. Email:lipg@outlook.com.
 */
public class EditUserForm implements Serializable {
    @NotNull(message = "用户id不能为空")
    private Long id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 二次输入的密码 */
    private String repassword;
    /** 真实姓名 */
    @NotBlank(message = "真实姓名不能为空")
    @Size(min = 2, max = 32, message = "真实姓名长度无效，允许长度2-32位")
    private String realName;
    /** 电话 */
    @NotBlank(message = "邮箱地址不能为空")
    @Email(message = "不是有效的邮箱地址")
    private String email;
    /** 手机号 */
    @NotBlank(message = "电话号码不能为空")
    private String phone;
    /** 备注 */
    @NotNull(message = "备注信息不能为空")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (! (o instanceof EditUserForm)) {
            return false;
        }
        EditUserForm that = (EditUserForm) o;
        return Objects.equal(id, that.id) && Objects.equal(password, that.password) && Objects.equal(repassword, that.repassword) &&
               Objects.equal(realName, that.realName) && Objects.equal(email, that.email) && Objects.equal(phone, that.phone) &&
               Objects.equal(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, password, repassword, realName, email, phone, remark);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("password", password)
                .add("repassword", repassword)
                .add("realName", realName)
                .add("email", email)
                .add("phone", phone)
                .add("remark", remark)
                .toString();
    }
}
