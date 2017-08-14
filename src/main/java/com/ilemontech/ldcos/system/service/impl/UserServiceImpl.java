package com.ilemontech.ldcos.system.service.impl;

import com.ilemontech.ldcos.system.entity.User;
import com.ilemontech.ldcos.system.mapper.UserMapper;
import com.ilemontech.ldcos.system.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaicl
 * @since 2017-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}
