package com.goviami.dartmsg.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.goviami.dartmsg.service.config.ServiceAppBoot;

@Configuration
@EnableAutoConfiguration
@PropertySources(value = { @PropertySource("classpath:swagger-${app.env}.properties") })
@ComponentScan(basePackages = { "com.goviami.dartmsg.web", "com.goviami.dartmsg.common" })
@Import(value = { ServiceAppBoot.class })
public class WebAppBoot extends SpringBootServletInitializer {
	/**
	 * Method to load spring context.
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebAppBoot.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebAppBoot.class);
	}
}
