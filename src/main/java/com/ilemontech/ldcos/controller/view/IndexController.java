package com.ilemontech.ldcos.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页控制器
 *
 * @author lipangeng, Email:lipg@outlook.com
 * @version 1.0 on 2017/5/21 下午12:05
 * @since 1.0 Created by lipangeng on 2017/5/21 下午12:05. Email:lipg@outlook.com.
 */
@Controller
@RequestMapping
public class IndexController {
    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    /** 模板路径 */
    private static final String TEMPLATE_PATH = "";

    /**
     * 主页
     *
     * @since 1.0 Created by lipangeng on 2017/5/21 下午12:07. Email:lipg@outlook.com.
     */
    @RequestMapping({"/", "index"})
    public String index() {
        return "index";
    }
}
