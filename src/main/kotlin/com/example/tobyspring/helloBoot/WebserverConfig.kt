package com.example.tobyspring.helloBoot

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration(proxyBeanMethods = false)
class WebserverConfig {
    @Bean
    fun customWebServerFactory():ServletWebServerFactory=TomcatServletWebServerFactory().also{
        it.port=9090
    }
}