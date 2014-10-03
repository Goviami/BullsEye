package com.goviami.dartmsg.dataaccess.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(value = { @PropertySource("classpath:bullseye-dartmsg-datasource.properties") })
public class DataaccessSpringConfig {

}
