package com.ilemontech.ldcos.system.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ilemontech.ldcos.system.common.BaseController;

/**
 * index
 * @author zhaicl
 * @date 2017年8月14日 上午11:25:30
 */
@Controller
public class IndexController extends BaseController {

	@RequestMapping(value = {"/", "/index"})
	public String index() {
		return "index";
	}
	
	
	
	
	@RequestMapping(value="/system/common/leftMenu")
	public String leftMenu(){
		
		return "/common/menu";
	}
}
