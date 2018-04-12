package com.image.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/upload").setViewName("index");
		registry.addViewController("/audio").setViewName("Audio");
		registry.addViewController("/play").setViewName("play");
	}


	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("src/main/resources/images//**").addResourceLocations("file:src/main/resources/images/");
//	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	    registry.beanName();
	}
}