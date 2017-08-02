package com.ilemontech.ldcos.entity.constant;

/**
 * 用户的常量
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/8 下午9:43
 * @since 1.0 Created by lipangeng on 2017/5/8 下午9:43. Email:lipg@outlook.com.
 */
public class UserConstant {
    /** 用户账户状态，只能增加 */
    public enum Status {
        DISABLE, // 禁用
        ENABLE, // 启用
        LOCKED, // 锁定
        EXPIRED, // 账户已过期
        PASSWORD_EXPIRED // 密码已过期
    }
}
