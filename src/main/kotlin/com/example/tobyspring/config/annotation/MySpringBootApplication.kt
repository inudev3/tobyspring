package com.example.tobyspring.config.annotation

import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target( AnnotationTarget.CLASS)
@Component
@ComponentScan
@EnableMyAutoConfiguration
annotation class MySpringBootApplication()
