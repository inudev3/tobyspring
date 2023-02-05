package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.MyAutoConfiguration
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.core.type.AnnotatedTypeMetadata


@MyAutoConfiguration
@Conditional(TomCatWebServerConfig.TomWebServerConfigCondition::class)
class TomCatWebServerConfig{
    class TomWebServerConfigCondition :Condition{
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
                return false
        }
    }

    @Bean("tomcatWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory = TomcatServletWebServerFactory()

}