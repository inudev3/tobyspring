package com.example.tobyspring.config.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class MyConfigurationProperties(val prefix:String)
