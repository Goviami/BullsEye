package com.goviami.dartmsg.dataaccess.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@EnableAutoConfiguration
@PropertySources(value = { @PropertySource("classpath:datasource-${app.env}.properties") })
@ComponentScan(basePackages = { "com.goviami.dartmsg.dataaccess" })
public class DataaccessAppBoot {
	/**
	 * Method to load spring context.
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DataaccessAppBoot.class, args);
	}
}
