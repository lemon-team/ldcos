package com.ilemontech.ldcos.system.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ilemontech.ldcos.system.common.BaseController;
import com.ilemontech.ldcos.system.common.SessionUtils;
import com.ilemontech.ldcos.system.entity.User;
import com.ilemontech.ldcos.system.service.IUserService;

/**
 * login
 * @author zhaicl
 * @date 2017年8月23日 上午10:46:11
 */
@Controller
public class LoginController extends BaseController{

	@Autowired
	private IUserService userService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){		
		return "login";
	}
		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginPost(HttpServletRequest request,ModelMap model,String username,String password){
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
			model.put("message", "用户名或者密码不能为空");
			return "login";
		}
		User user=userService.selectOne(new EntityWrapper<User>().eq("username", username));
		DigestUtils.md5Hex(password);
		
		if(user==null || !user.getPassword().equals(DigestUtils.md5Hex(password))){
			model.put("message", "用户名或者密码不正确");
			return "login";
		}
		SessionUtils.login(user, request);
		return REDIRECT+"index";
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String loginPost(HttpServletRequest request,ModelMap model){
		SessionUtils.logout(request);
		return "redirect:/login";
	}
}
