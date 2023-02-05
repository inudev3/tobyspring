package com.example.tobyspring.config.autoconfig


import com.example.tobyspring.config.annotation.MyAutoConfiguration
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.core.type.AnnotatedTypeMetadata


@MyAutoConfiguration
@Conditional(JettyWebServerConfig.JettyWebServerConfigCondition::class)
class JettyWebServerConfig{
    class JettyWebServerConfigCondition :Condition{
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return true
        }
    }

    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory = JettyServletWebServerFactory()

}