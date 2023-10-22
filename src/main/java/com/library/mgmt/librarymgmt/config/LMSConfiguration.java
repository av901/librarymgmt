package com.library.mgmt.librarymgmt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LMSConfiguration {
	
	@Bean
	public Properties additionalProps() {
	    Properties jpaProps = new Properties();
	   // jpaProps.put("javax.persistence.create-database-schemas", true);
	    return jpaProps;
	}

}
