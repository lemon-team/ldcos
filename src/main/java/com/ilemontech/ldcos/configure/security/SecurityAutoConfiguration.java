package com.ilemontech.ldcos.configure.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全授权配置
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/7 上午1:38
 * @since 1.0 Created by lipangeng on 2017/5/7 上午1:38. Email:lipg@outlook.com.
 */
@Configuration
public class SecurityAutoConfiguration extends WebSecurityConfigurerAdapter {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(SecurityAutoConfiguration.class);
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 密码加密器，bean存在则会自动装备
     *
     * @since 1.0 Created by lipangeng on 2017/5/7 上午2:34. Email:lipg@outlook.com.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证Provider
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午10:27. Email:lipg@outlook.com.
     */
    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        // 抛出userNotFound异常
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return authenticationProvider;
    }

    /**
     * 授权配置
     *
     * @since 1.0 Created by lipangeng on 2017/5/7 上午1:39. Email:lipg@outlook.com.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/img/**", "/fonts/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .httpBasic()
                .and()
                .rememberMe();
    }

    /**
     * web安全配置
     *
     * @since 1.0 Created by lipangeng on 2017/5/7 上午2:22. Email:lipg@outlook.com.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * 配置认证方式
     *
     * @since 1.0 Created by lipangeng on 2017/5/7 上午2:20. Email:lipg@outlook.com.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
}
