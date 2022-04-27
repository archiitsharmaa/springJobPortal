package com.springsecurity.config;

import javax.sql.DataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class MyAppConfig implements WebMvcConfigurer{
	
	@Bean
	InternalResourceViewResolver ViewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		
		
		return viewResolver;	
		
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		System.out.println("Getting loaded");
	    System.out.println(registry.addResourceHandler("/template/**").addResourceLocations("/WEB-INF/template/"));
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		
		return jdbcTemplate;
	
	}
	
	//connect to the database
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/user_registration_database");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("archit04");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return driverManagerDataSource;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	
	

}
