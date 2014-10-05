package com.goviami.dartmsg.service.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import com.goviami.dartmsg.service.converter.api.UserDOToUserConverter;
import com.goviami.dartmsg.service.converter.db.UserDetailsToUserDetailsDOConverter;
import com.goviami.dartmsg.service.converter.db.UserRegistryToUserDOConverter;

@Configuration
public class ServiceModuleSpringConfig {
	/**
	 * Register Converters for Conversion Service.
	 * 
	 * @return {@link ConversionServiceFactoryBean}
	 */
	@Bean(name = "conversionService")
	public ConversionServiceFactoryBean conversionService() {
		ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
		factoryBean.setConverters(appConverters());
		return factoryBean;
	}

	/**
	 * Construct Converters for Conversion Service.
	 * 
	 * @return set of registered converters.
	 */
	private Set<Converter<?, ?>> appConverters() {
		Set<Converter<?, ?>> converters = new HashSet<Converter<?, ?>>();
		converters.add(new UserDOToUserConverter());
		converters.add(new UserRegistryToUserDOConverter());
		converters.add(new UserDetailsToUserDetailsDOConverter());
		return converters;
	}
}
