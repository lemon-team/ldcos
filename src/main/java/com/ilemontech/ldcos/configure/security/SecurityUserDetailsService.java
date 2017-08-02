package com.ilemontech.ldcos.configure.security;

import com.ilemontech.ldcos.entity.UserEntity;
import com.ilemontech.ldcos.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户信息获取的service，用来获取认证信息。bean存在的情况下将自动装配
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/7 上午2:25
 * @since 1.0 Created by lipangeng on 2017/5/7 上午2:25. Email:lipg@outlook.com.
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(SecurityUserDetailsService.class);
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByUserName(username);
        // 如果用户不存在则抛出相应的异常
        if (Objects.isNull(userEntity)) {
            throw new UsernameNotFoundException(String.format("用户:%s不存在", username));
        }
        return new SecurityUserDetails(userEntity);
    }
}
