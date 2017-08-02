package com.ilemontech.ldcos.service;

import com.ilemontech.ldcos.entity.UserEntity;
import com.github.pagehelper.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

/**
 * 用户service类
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/8 下午9:50
 * @since 1.0 Created by lipangeng on 2017/5/8 下午9:50. Email:lipg@outlook.com.
 */
@Service
public interface UserService {
    /**
     * 获取用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午9:53. Email:lipg@outlook.com.
     */
    UserEntity findOne(Long id);

    /**
     * 通过用户名查找用户
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午9:51. Email:lipg@outlook.com.
     */
    UserEntity findByUserName(String userName);

    /**
     * 更新用户密码
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:03. Email:lipg@outlook.com.
     */
    boolean updatePassword(UserEntity userEntity);


    /**
     * 更新用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/6/5 下午5:08. Email:lipg@outlook.com.
     */
    boolean updateUser(UserEntity userEntity);

    /**
     * 插入新用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:19. Email:lipg@outlook.com.
     */
    boolean insert(UserEntity userEntity);

    /**
     * 查询全部用户信息
     *
     * @param isFuzzy
     *         模糊查询
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午4:57. Email:lipg@outlook.com.
     */
    Page<UserEntity> findAllUser(UserEntity user, RowBounds rowBounds, boolean isFuzzy);

    /**
     * 加密密码
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:03. Email:lipg@outlook.com.
     */
    String encodePassord(String password);

    /**
     * 删除用户
     *
     * @since 1.0 Created by lipangeng on 2017/6/5 下午5:09. Email:lipg@outlook.com.
     */
    boolean deleteUser(Long id);
}
