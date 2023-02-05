package com.example.tobyspring.helloBoot.service


import org.springframework.stereotype.Service

@Service
class HelloServiceImpl : HelloService {
    override fun sayHello(name: String)= "hello $name"
}