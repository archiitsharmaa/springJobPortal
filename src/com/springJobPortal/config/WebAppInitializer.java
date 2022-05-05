package com.springJobPortal.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//intializing the web app with servlet
public class WebAppInitializer implements WebApplicationInitializer {
	
	private static Logger log = Logger.getLogger(WebApplicationInitializer.class.getName());

	// configuring the app startup
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		try {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
				new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		}
		catch(Exception e) {
			log.error("Error in the onStartup in servlet context");
		}

	}
}
