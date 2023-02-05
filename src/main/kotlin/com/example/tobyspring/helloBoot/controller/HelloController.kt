package com.example.tobyspring.helloBoot.controller


import com.example.tobyspring.helloBoot.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(val helloService: HelloService) {
    @GetMapping("/hello")
    fun hello(@RequestParam("name") name:String):String{
        if(name.trim().isBlank()) throw IllegalArgumentException()
        return helloService.sayHello(name)
    }
}