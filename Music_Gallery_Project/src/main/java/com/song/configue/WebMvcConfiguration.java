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
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
 @EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{
         
	
	
	
	
//	@PostMapping
//	public String Index(Model model) {
//	    // omitted.
//	    return "index";
//	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	    registry.beanName();
	}
	
//	 @GetMapping("/")
//	    public String index() {
//	      return "fileupload";
//	    }
	  
	@Override
   public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/upload").setViewName("index");
	}
	 

	
//	@RequestMapping({"/login", "/main/**"})
//    public String index() {
//        return "index";
//    }
		
//	   try
//	   {
//		   registry.addViewController("/upload").setViewName("index");
//		//registry.addRedirectViewController("/", "index.html");
//	   }catch(Exception e)
//	   {
//		   System.out.println(e);
//	   }
//	}
//	
	
//	@Bean
//    public WebMvcConfigurerAdapter forwardToIndex() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                // forward requests to /admin and /user to their index.html
//                registry.addViewController("/admin").setViewName(
//                        "forward:/admin/index.html");
//                
//            }
//        };
//    }

    
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index.html");
//    }

	}
