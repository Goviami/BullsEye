package com.goviami.dartmsg.web.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;

@Configuration
@EnableSwagger
public class WebModuleSpringConfig extends WebMvcConfigurerAdapter {

	/**
	 * Spring Swagger Configuration.
	 */
	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Configure Spring MVC Message Converters.
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jacksonMessageConverter());
		super.configureMessageConverters(converters);
	}

	/**
	 * Custom Jackson Message Converter.
	 * 
	 * @return {@link MappingJackson2HttpMessageConverter}
	 */
	private MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	/**
	 * Spring Swagger Configuration.
	 * 
	 * @param springSwaggerConfig {@link SpringSwaggerConfig}
	 */
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	/**
	 * Swagger Spring MVC Plugin.
	 * 
	 * @return {@link SwaggerSpringMvcPlugin}
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(springSwaggerConfig).swaggerGroup("v1").apiInfo(apiInfo())
				.includePatterns(".*user.*");
	}

	/**
	 * Build API Info.
	 * 
	 * @return {@link ApiInfo}
	 */
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"BullsEye Dart Messaging Service",
				"This is BullsEye Application Api hosting server. This page will provide the list of all available BullsEye Api's documented, "
						+ "<br><br>to help consumers understand the Api's functionality and use appropriately. You can find more about BullsEye at <a href='http://goviami.com/BullsEye'>http://goviami.com/BullsEye</a>. <br><br>",
				"Terms of Service", "Contact BullsEye Team", "Goviami License 1.0",
				"http://goviami.com/BullsEye/license");
		return apiInfo;
	}
}
