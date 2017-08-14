package com.ilemontech.ldcos;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 启动类
 * 
 */
@SpringBootApplication
public class IdcosApplication extends WebMvcConfigurerAdapter {

	private static Logger logger = LoggerFactory.getLogger(IdcosApplication.class);

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(IdcosApplication.class);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	@Bean
	public ServletContextInitializer initializer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext)throws ServletException {
				servletContext.setAttribute("staticPath", "");
				servletContext.setAttribute("contextPath", "");
				servletContext.setAttribute("version", "20170810");
			}
		};
	}
	/**
	 * 自定义异常
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN,"/common/403");
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/common/404");
				ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/common/500");
				container.addErrorPages(error403Page, error404Page,error500Page);
			}
		};
	}
	/**
	 * 配置拦截器
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(new
		// UserLoginInterceptor()).addPathPatterns("/**")
		// .excludePathPatterns("/jyj/login","/jyj/logout","/jyj/getCaptcha")
		// .excludePathPatterns("/b2bjs/**","/css/**","/images/**","/img/**","/jquery/**","/js/**","/styles/**","/favicon.ico");
	}

	public static void main(String[] args) {
		logger.info("开始启动......");
		SpringApplication.run(IdcosApplication.class, args);
		logger.info("启动完成......");
	}

}
