package com.springJobPortal.config;

import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//configurating the jpa configs
@Configuration
//base repositiories for searching for jpa repository
@EnableJpaRepositories(basePackages = { "com.springJobPortal.*" })
@EnableTransactionManagement
public class JpaConfig {
	
	private static Logger log = Logger.getLogger(JpaConfig.class.getName());

	// configuring entitiy manager for managing entity tables
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		
		try {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("SalesDB");
		
		log.info("entityManagerFactory intialized");

		return factoryBean;
		}
		catch(Exception e) {
			log.error("Error in entityManagerFactory");
		}
		
		return null;
	}

	// configuring transaction managers for manager
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		
		try {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		
		log.info("transactionManager intialized");

		return transactionManager;
		}
		
		catch(Exception e) {
			
			log.error("error in transactionManager");
			return null;
		}
	}
}
