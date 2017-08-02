package com.ilemontech.ldcos.configure.security;

import com.ilemontech.ldcos.entity.UserEntity;
import com.ilemontech.ldcos.entity.constant.UserConstant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

/**
 * 安全认证用户信息
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/7 上午2:36
 * @since 1.0 Created by lipangeng on 2017/5/7 上午2:36. Email:lipg@outlook.com.
 */
public class SecurityUserDetails implements UserDetails {
    /** 用户Id信息 */
    private Long id;
    /** 用户信息实体 */
    private UserEntity user;
    /** 真实姓名 */
    private String realName;
    /** 头像地址 */
    private String headUrl;

    public SecurityUserDetails(UserEntity user) {
        this.id = user.getId();
        this.user = user;
        this.realName = user.getRealName();
    }

    /**
     * 返回账户权限
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:00. Email:lipg@outlook.com.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 返回用户密码
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:00. Email:lipg@outlook.com.
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * 返回用户名
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:00. Email:lipg@outlook.com.
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * 返回用户是否已经过期
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:00. Email:lipg@outlook.com.
     */
    @Override
    public boolean isAccountNonExpired() {
        return ! Objects.equals(user.getStatus(), UserConstant.Status.EXPIRED.ordinal()) &&
               ! (user.getExpiredTime() != null && user.getExpiredTime().getTime() <= System.currentTimeMillis());
    }

    /**
     * 返回用户是否已经锁定
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:01. Email:lipg@outlook.com.
     */
    @Override
    public boolean isAccountNonLocked() {
        return ! Objects.equals(user.getStatus(), UserConstant.Status.LOCKED.ordinal());
    }

    /**
     * 账户密码是否已经过期
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:01. Email:lipg@outlook.com.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return ! Objects.equals(user.getStatus(), UserConstant.Status.PASSWORD_EXPIRED.ordinal()) &&
               ! (user.getPasswordExpiredTime() != null && user.getPasswordExpiredTime().getTime() <= System.currentTimeMillis());
    }

    /**
     * 账户是否启用
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:01. Email:lipg@outlook.com.
     */
    @Override
    public boolean isEnabled() {
        return Objects.equals(user.getStatus(), UserConstant.Status.ENABLE.ordinal());
    }

    public UserEntity getUser() {
        return user;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public Long getId() {
        return id;
    }
}
