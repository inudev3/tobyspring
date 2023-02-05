package com.example.tobyspring.config.autoconfig


import com.example.tobyspring.config.annotation.ConditionalOnMyClass
import com.example.tobyspring.config.annotation.MyAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils


@MyAutoConfiguration
@ConditionalOnMyClass("org.eclipse.jetty.server.Server")

class JettyWebServerConfig{

    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "server", name = arrayOf("type"), havingValue = "jetty")
    fun servletWebServerFactory(): ServletWebServerFactory = JettyServletWebServerFactory()

}