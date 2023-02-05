package com.example.tobyspring.helloBoot

import com.example.tobyspring.config.annotation.MySpringBootApplication
import org.springframework.boot.runApplication

@MySpringBootApplication

class TobyspringApplication

fun main(args: Array<String>) {

    runApplication<TobyspringApplication>(*args)
}


