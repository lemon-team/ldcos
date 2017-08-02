package com.ilemontech.ldcos.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 登陆控制器
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/9 下午11:48
 * @since 1.0 Created by lipangeng on 2017/5/9 下午11:48. Email:lipg@outlook.com.
 */
@Controller
@RequestMapping
public class LoginController {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    /** 模板路径 */
    private static final String TEMPLATE_PATH = "/";

    /**
     * 登陆页面
     *
     * @since 1.0 Created by lipangeng on 2017/5/9 下午11:49. Email:lipg@outlook.com.
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        // 处理异常信息
        Object loginExcepiton = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        // 错误信息使用一次之后则删除错误信息。
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        String errorMsg = null;
        if (loginExcepiton instanceof LockedException) {
            errorMsg = "账户已被锁定~！";
        } else if (loginExcepiton instanceof DisabledException) {
            errorMsg = "账户已被禁用~！";
        } else if (loginExcepiton instanceof AccountExpiredException) {
            errorMsg = "账户已过期~！";
        } else if (loginExcepiton instanceof UsernameNotFoundException) {
            errorMsg = "用户不存在~！";
        } else if (loginExcepiton instanceof CredentialsExpiredException) {
            errorMsg = "密码已过期~！";
        } else if (loginExcepiton instanceof BadCredentialsException) {
            errorMsg = "账号或密码错误，请重试~！";
        } else if (loginExcepiton != null) {
            errorMsg = "登陆失败，请重试~！";
        }
        model.addAttribute("errorMsg", errorMsg);
        return TEMPLATE_PATH + "login";
    }
}
