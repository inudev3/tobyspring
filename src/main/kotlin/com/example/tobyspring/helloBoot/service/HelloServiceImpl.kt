package com.example.tobyspring.helloBoot.service


import com.example.tobyspring.helloBoot.repository.HelloRepository
import org.springframework.stereotype.Service

@Service
class HelloServiceImpl (private val helloRepository: HelloRepository): HelloService {

    override fun sayHello(name: String)= kotlin.run {
        helloRepository.increaseCount(name)
        "hello $name"
    }
}