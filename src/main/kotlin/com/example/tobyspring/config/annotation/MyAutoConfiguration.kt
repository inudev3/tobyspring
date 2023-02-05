package com.example.tobyspring.config.annotation

import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Configuration(proxyBeanMethods = false)
annotation class MyAutoConfiguration()
