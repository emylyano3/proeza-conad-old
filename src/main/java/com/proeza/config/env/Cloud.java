package com.proeza.config.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Profile("cloud")
@Configuration
public class Cloud {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer () {
    	PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("env/cloud/app-config.properties"));
        ppc.setNullValue("");
        return ppc;
    }
}