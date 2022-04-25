package com.springsecurity.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class[] configFles = {MyAppConfig.class};		
		
		
		
		return configFles;
	}

	@Override
	protected String[] getServletMappings() {
		
		String[] mappings = {"/"};
		
		
		
		return mappings;
	}

}
