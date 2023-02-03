package com.example.tobyspring

import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

@Configuration
@ComponentScan
class TobyspringApplication{

    @Bean
    fun servletWebServerFactory():ServletWebServerFactory=TomcatServletWebServerFactory()

    @Bean
    fun dispatcherServlet():DispatcherServlet=DispatcherServlet()
}

fun main(args: Array<String>) {

    SpringApplication.runApplication<TobyspringApplication>(*args)
}


