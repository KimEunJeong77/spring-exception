package com.example.demo.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.system.interceptor.AuthInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    
	private final AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(authInterceptor)
		.excludePathPatterns("/")
		.excludePathPatterns("/login")
		.excludePathPatterns("/logout")
		.excludePathPatterns("/error")
		.excludePathPatterns("/login/form");
	}
}