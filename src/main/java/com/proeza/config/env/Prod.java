package com.proeza.config.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Profile("prod")
@Configuration
public class Prod {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer () {
		PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("env/prod/app-config.properties"));
		ppc.setNullValue("");
		return ppc;
	}
}