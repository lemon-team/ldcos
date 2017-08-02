package com.ilemontech.ldcos.repository;

import com.ilemontech.ldcos.entity.UserEntity;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 用户信息操作库
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/6 上午9:00
 * @since 1.0 Created by lipangeng on 2017/5/6 上午9:00. Email:lipg@outlook.com.
 */
@Mapper
public interface UserRepository {
    /**
     * 通过id查询单个对象
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 上午12:46. Email:lipg@outlook.com.
     */
    UserEntity findOne(@Param("id") Long id);

    /**
     * 通过用户名查询用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 上午12:46. Email:lipg@outlook.com.
     */
    UserEntity findByUserName(@Param("userName") String userName);

    /**
     * 插入新用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:10. Email:lipg@outlook.com.
     */
    boolean insert(UserEntity user);

    /**
     * 更新用户密码
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:11. Email:lipg@outlook.com.
     */
    boolean updatePassword(@Param("id") Long id, @Param("password") String password);

    /**
     * 通过内容动态查询
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午4:43. Email:lipg@outlook.com.
     */
    Page<UserEntity> findAllSelective(UserEntity user, RowBounds rowBounds);

    /**
     * 通过内容动态查询,userName是Like模式
     *
     * @since 1.0 Created by lipangeng on 2017/6/1 下午4:43. Email:lipg@outlook.com.
     */
    Page<UserEntity> findAllByLikeAndSelective(UserEntity user, RowBounds rowBounds);

    /**
     * 更新用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/6/5 下午5:10. Email:lipg@outlook.com.
     */
    boolean update(UserEntity userEntity);

    /**
     * 删除用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/6/5 下午5:10. Email:lipg@outlook.com.
     */
    boolean delete(Long id);
}
