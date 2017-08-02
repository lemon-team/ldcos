package com.ilemontech.ldcos.entity;

import com.ilemontech.ldcos.entity.constant.UserConstant;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Date;

/**
 * 账户信息实体
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/6 上午8:55
 * @since 1.0 Created by lipangeng on 2017/5/6 上午8:55. Email:lipg@outlook.com.
 */
public class UserEntity extends IdEntity {
    /** 用户名 */
    private String username;
    /** 真实姓名 */
    private String realName;
    /** 密码 */
    private String password;
    /** email */
    private String email;
    /** 电话号码 */
    private String phone;
    /** 状态,默认状态 */
    private Integer status = UserConstant.Status.ENABLE.ordinal();
    /** 备注 */
    private String remark;
    /** 登陆ip */
    private String loginIp;
    /** 登陆时间 */
    private Date loginTime;
    /** 账户过期时间 */
    private Date expiredTime;
    /** 密码过期时间 */
    private Date passwordExpiredTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Date getPasswordExpiredTime() {
        return passwordExpiredTime;
    }

    public void setPasswordExpiredTime(Date passwordExpiredTime) {
        this.passwordExpiredTime = passwordExpiredTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return Objects.equal(username, that.username) && Objects.equal(realName, that.realName) && Objects.equal(password, that.password) &&
               Objects.equal(email, that.email) && Objects.equal(phone, that.phone) && Objects.equal(status, that.status) &&
               Objects.equal(remark, that.remark) && Objects.equal(loginIp, that.loginIp) && Objects.equal(loginTime, that.loginTime) &&
               Objects.equal(expiredTime, that.expiredTime) && Objects.equal(passwordExpiredTime, that.passwordExpiredTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username,
                                realName,
                                password,
                                email,
                                phone,
                                status,
                                remark,
                                loginIp,
                                loginTime,
                                expiredTime,
                                passwordExpiredTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("createTime", createTime)
                .add("updateTime", updateTime)
                .add("username", username)
                .add("realName", realName)
                .add("password", password)
                .add("email", email)
                .add("phone", phone)
                .add("status", status)
                .add("remark", remark)
                .add("loginIp", loginIp)
                .add("loginTime", loginTime)
                .add("expiredTime", expiredTime)
                .add("passwordExpiredTime", passwordExpiredTime)
                .toString();
    }
}

