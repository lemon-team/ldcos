package com.ilemontech.ldcos.repository;

import com.ilemontech.ldcos.entity.GroupEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息操作库
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/6 上午9:00
 * @since 1.0 Created by lipangeng on 2017/5/6 上午9:00. Email:lipg@outlook.com.
 */
@Mapper
public interface GroupRepository {
    /**
     * 通过id查询单个对象
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 上午12:46. Email:lipg@outlook.com.
     */
    GroupEntity findOne(@Param("id") Long id);

    /**
     * 插入新用户信息
     *
     * @since 1.0 Created by lipangeng on 2017/5/8 下午11:10. Email:lipg@outlook.com.
     */
    boolean insert(GroupEntity role);
}
