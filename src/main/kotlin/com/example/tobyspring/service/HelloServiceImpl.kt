package com.example.tobyspring.service

class HelloServiceImpl :HelloService{
    override fun sayHello(name: String)= "hello $name"
}