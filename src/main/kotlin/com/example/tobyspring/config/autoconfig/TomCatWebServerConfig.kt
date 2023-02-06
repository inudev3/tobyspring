package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.ConditionalOnMyClass
import com.example.tobyspring.config.annotation.EnableMyConfigurationProperties
import com.example.tobyspring.config.annotation.MyAutoConfiguration
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Import
import org.springframework.core.env.Environment
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils


@MyAutoConfiguration
@ConditionalOnMyClass("org.apache.catalina.startup.Tomcat")
class TomCatWebServerConfig{

//    val log= LoggerFactory.getLogger(TomCatWebServerConfig::class.java)
    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "server", name = arrayOf("type"), havingValue = "tomcat")
    fun servletWebServerFactory(serverProperties: ServerProperties): ServletWebServerFactory = TomcatServletWebServerFactory().also{

        it.contextPath=serverProperties.contextPath
        it.port=serverProperties.port
    }

}