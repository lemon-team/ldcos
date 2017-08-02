package com.ilemontech.ldcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 启动类，继承自{@link SpringBootServletInitializer}类,
 * 并重写了{@link SpringBootServletInitializer#configure(SpringApplicationBuilder)}方法，使其支持普通的Tomcat方式以及命令行方式启动
 *
 * @since 1.0 Created by lipangeng on 2017/3/31 上午12:20. Email:lipg@outlook.com.
 */
@SpringBootApplication
public class PortalApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PortalApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }

}
