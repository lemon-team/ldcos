package com.ilemontech.ldcos.system.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础类
 * @author zhaicl
 * @date 2017年8月3日 下午2:17:19
 */
public class BaseController {

	 /** 控制器页面跳转 */
	protected String REDIRECT = "redirect:/";
	
    /** 控制器请求转发 */
	protected String FORWARD = "forward:/";
	/**
	 * logger
	 */
	protected Logger logger=LoggerFactory.getLogger(getClass());
	
	
	
	
}
