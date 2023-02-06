package com.example.tobyspring.helloBoot

import com.example.tobyspring.config.annotation.EnableMyConfigurationProperties
import com.example.tobyspring.config.annotation.MySpringBootApplication
import com.example.tobyspring.config.autoconfig.ServerProperties
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MySpringBootApplication
//@EnableMyConfigurationProperties(ServerProperties::class)
class TobyspringApplication{
    @Bean
    fun applicationRunner(env:Environment):ApplicationRunner = ApplicationRunner { args->
        env.getProperty("my.name") .let(::println)
    }
}

fun main(args: Array<String>) {

    runApplication<TobyspringApplication>(*args)
}


