package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.MyAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@MyAutoConfiguration
class PropertyPlaceholderConfig {
    @Bean
    fun propertySourcePlaceholderConfigurer():PropertySourcesPlaceholderConfigurer = PropertySourcesPlaceholderConfigurer()
}