package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.MyAutoConfiguration
import org.springframework.context.annotation.Bean

import org.springframework.web.servlet.DispatcherServlet

@MyAutoConfiguration
class DisPatcherServletConfig {

    @Bean
    fun dispatcherServlet(): DispatcherServlet = DispatcherServlet()
}