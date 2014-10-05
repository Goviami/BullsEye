package com.goviami.dartmsg.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.goviami.dartmsg.dataaccess.config.DataaccessAppBoot;

@Configuration
@EnableAutoConfiguration
@PropertySources(value = { @PropertySource("classpath:error-message.properties") })
@ComponentScan(basePackages = { "com.goviami.dartmsg.service" })
@Import(value = { DataaccessAppBoot.class })
public class ServiceAppBoot {
	/**
	 * Method to load spring context.
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceAppBoot.class, args);
	}
}
