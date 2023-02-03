package com.example.tobyspring.service

import com.example.tobyspring.annotation.MyAnnotation
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class HelloServiceImpl :HelloService{
    override fun sayHello(name: String)= "hello $name"
}