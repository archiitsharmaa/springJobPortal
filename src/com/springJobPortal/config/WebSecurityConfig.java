package com.springJobPortal.config;

import org.springframework.context.annotation.*;

import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.springJobPortal.customer.UserDetailsServiceImpl;

//configuration for the spring security
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// bean for userdetails service layer
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	// bean for retrearing thr encrypted passeord
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// dao authenticator
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		// sets customer details
		authProvider.setUserDetailsService(userDetailsService());
		// sets encrypted password
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	// configurer
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	// configures the urls according to the role based access
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/welcome").authenticated().antMatchers("/applyJob")
				.hasAuthority("Job Seeker").antMatchers("/candidateList").hasAuthority("Employer")
				.antMatchers("/joblist").authenticated().antMatchers("/postedJobs").hasAuthority("Employer")
				.antMatchers("/postJob").hasAuthority("Employer").and().formLogin().loginPage("/loginForm")
				.loginProcessingUrl("/process-login").permitAll().defaultSuccessUrl("/welcome").and().logout()
				.permitAll();
	}

	// allows the extrernal resources like css and js files to be included in the project
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
	}
}