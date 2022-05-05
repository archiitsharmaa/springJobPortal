package com.springJobPortal.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//scans every package with following pattern for MVC components
@ComponentScan("com.springJobPortal")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	
	private static Logger log = Logger.getLogger(WebMvcConfig.class.getName());

	// view Resolver for confgiguring view part of the app
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		try {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		log.info("Intialized InternalResourceViewResolver in web mvc config");
		return viewResolver;
		
		
		}
		catch (Exception e) {
			log.error("Error in the InternalResourceViewResolver in web mvc config");
		}
		
		return null;
	}

	// bean for password Encription
	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	// adds additional resources of js and css to be included in the project
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/template/**").addResourceLocations("/WEB-INF/template/");
	}

}
