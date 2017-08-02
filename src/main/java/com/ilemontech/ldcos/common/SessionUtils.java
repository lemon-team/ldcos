package com.ilemontech.ldcos.common;

import com.ilemontech.ldcos.configure.security.SecurityUserDetails;
import com.ilemontech.ldcos.constant.SessionConstant;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session 工具
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/7/7 上午10:34
 * @since 1.0 Created by lipangeng on 2017/7/7 上午10:34. Email:lipg@outlook.com.
 */
public class SessionUtils {
    private static final Logger logger = LoggerFactory.getLogger(SessionUtils.class);


    /**
     * 获取当前用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/7/7 上午10:45. Email:lipg@outlook.com.
     */
    public static SecurityUserDetails currentUserDetails() {
        return (SecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 是否有自动登录信息
     *
     * @since 1.0 Created by lipangeng on 2017/7/7 上午10:40. Email:lipg@outlook.com.
     */
    public static boolean hasRememberMe() {
        HttpServletRequest request = ServletUtils.getRequest();
        Preconditions.checkNotNull(request, "无法获取当前的Reuqest信息");
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return false;
        }
        for (Cookie cookie : cookies) {
            if (SessionConstant.COOKIE_REMEMBER_ME_KEY.equals(cookie.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除自动登录信息
     *
     * @since 1.0 Created by lipangeng on 2017/7/7 上午10:39. Email:lipg@outlook.com.
     */
    public static void removeRememberMe() {
        HttpServletResponse response = ServletUtils.getResponse();
        Preconditions.checkNotNull(response, "无法获取当前的Response信息");
        Cookie cookie = new Cookie(SessionConstant.COOKIE_REMEMBER_ME_KEY, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


}
