package com.ssafy.config;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.interceptor.ConfirmInterceptor;

@Configuration
@MapperScan(basePackages = {"com.ssafy.**.mapper"})
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	private final List<String> patterns = Arrays.asList("/article/*", "/admin", "/user/list");
	
	private ConfirmInterceptor confirmInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	public WebMvcConfiguration(ConfirmInterceptor confirmInterceptor) {
		this.confirmInterceptor = confirmInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(confirmInterceptor).addPathPatterns(patterns);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

}
