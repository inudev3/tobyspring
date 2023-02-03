package com.example.tobyspring.controller

import com.example.tobyspring.service.HelloService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloController(val helloService: HelloService) {
    @GetMapping("/hello")
    fun hello(@RequestParam("name") name:String) = helloService.sayHello(name)
}