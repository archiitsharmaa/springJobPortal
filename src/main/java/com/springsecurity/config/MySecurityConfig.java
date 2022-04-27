package com.springsecurity.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//this class creates the spring security filter chain
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	//some details
	//username, password, roles
	//archit, archit04, admin
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//method to create users
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	//load from database
	//username password role
		
		 auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder) ;
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/employer").hasAuthority("Employer")
		.antMatchers("/candidate").hasAuthority("Job Seeker")
		.antMatchers("/js/**", "/css/**").permitAll()
		.and()
			.formLogin().loginPage("/loginForm").loginProcessingUrl("/process-login").permitAll().defaultSuccessUrl("/welcome")
			.and()
			.httpBasic()
			.and().logout()  
			.and().exceptionHandling().accessDeniedPage("/loginForm");
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	            .ignoring()
	            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
	}
	
	
	
	
	
}
