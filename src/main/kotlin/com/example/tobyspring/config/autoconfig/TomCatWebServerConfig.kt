package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.ConditionalOnMyClass
import com.example.tobyspring.config.annotation.MyAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.core.env.Environment
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils


@MyAutoConfiguration
@ConditionalOnMyClass("org.apache.catalina.startup.Tomcat")
class TomCatWebServerConfig{

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "server", name = arrayOf("type"), havingValue = "tomcat")
    fun servletWebServerFactory(env:Environment): ServletWebServerFactory = TomcatServletWebServerFactory().also{
        it.contextPath=env.getProperty("contextPath")
    }

}