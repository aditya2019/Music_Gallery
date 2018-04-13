package com.song.configue;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
 @EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {
    
@Override
public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/upload").setViewName("index");
	registry.addViewController("/audio").setViewName("Audio");
	
   }



//@Override
//public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	registry.addResourceHandler("src/main/resources/images//**").addResourceLocations("file:src/main/resources/images/");
//}
  @Override
 public void configureViewResolvers(ViewResolverRegistry registry) {
 registry.beanName();
  }
  
}