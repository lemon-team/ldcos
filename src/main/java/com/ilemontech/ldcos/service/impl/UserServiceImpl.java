package com.ilemontech.ldcos.service.impl;

import com.ilemontech.ldcos.common.SessionUtils;
import com.ilemontech.ldcos.entity.UserEntity;
import com.ilemontech.ldcos.repository.UserRepository;
import com.ilemontech.ldcos.service.UserService;
import com.github.pagehelper.Page;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * 用户service类
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/8 下午9:50
 * @since 1.0 Created by lipangeng on 2017/5/8 下午9:50. Email:lipg@outlook.com.
 */
@Service
public class UserServiceImpl implements UserService {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午9:53. Email:lipg@outlook.com.
     */
    @Override
    public UserEntity findOne(Long id) {
        return userRepository.findOne(id);
    }

    /**
     * 通过用户名查找用户
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午9:51. Email:lipg@outlook.com.
     */
    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    /**
     * 更新用户密码
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:03. Email:lipg@outlook.com.
     */
    @Override
    public boolean updatePassword(UserEntity userEntity) {
        return userRepository.updatePassword(userEntity.getId(), encodePassord(userEntity.getPassword()));
    }

    /**
     * 插入新用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:19. Email:lipg@outlook.com.
     */
    @Override
    public boolean insert(UserEntity userEntity) {
        userEntity.setPassword(encodePassord(userEntity.getPassword()));
        return userRepository.insert(userEntity);
    }

    /**
     * 查询全部用户信息
     *
     * @param isFuzzy
     *         模糊查询
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午4:57. Email:lipg@outlook.com.
     */
    @Override
    public Page<UserEntity> findAllUser(UserEntity user, RowBounds rowBounds, boolean isFuzzy) {
        return isFuzzy ? userRepository.findAllByLikeAndSelective(user, rowBounds) : userRepository.findAllSelective(user, rowBounds);
    }

    /**
     * 加密密码
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:03. Email:lipg@outlook.com.
     */
    @Override
    public String encodePassord(String password) {
        return passwordEncoder.encode(Objects.requireNonNull(password, "密码不能为空，空密码无法进行加密。"));
    }

    /**
     * 删除用户
     *
     * @param id
     *
     * @since 1.0 Created by lipangeng on 2017/6/5 下午5:09. Email:lipg@outlook.com.
     */
    @Override
    public boolean deleteUser(Long id) {
        return ! Objects.equals(id, SessionUtils.currentUserDetails().getId()) && userRepository.delete(id);
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        userEntity.setUpdateTime(new Date());
        return userRepository.update(userEntity);
    }
}
