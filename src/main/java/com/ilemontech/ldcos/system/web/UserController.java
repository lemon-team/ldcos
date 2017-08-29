package com.ilemontech.ldcos.system.web;


import org.springframework.web.bind.annotation.RequestMapping;

import com.ilemontech.ldcos.system.common.BaseController;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaicl
 * @since 2017-08-03
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController{
	
	private static String BASE_PATH="/system/user/";
	
	
	@RequestMapping("list")
	public String list(){
		return BASE_PATH+"index";
	}
}
