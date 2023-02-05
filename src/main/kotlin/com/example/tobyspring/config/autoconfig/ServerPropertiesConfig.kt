package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.MyAutoConfiguration
import com.example.tobyspring.config.annotation.MyConfigurationProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
@MyConfigurationProperties
class ServerProperties(val contextPath:String, val port:Int)


