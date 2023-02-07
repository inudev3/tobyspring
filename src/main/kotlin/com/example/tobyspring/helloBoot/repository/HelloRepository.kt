package com.example.tobyspring.helloBoot.repository

import com.example.tobyspring.helloBoot.domain.Hello

interface HelloRepository {
    fun findHello(name:String): Hello?
    fun increaseCount(name:String)
    fun countOf(name:String)= findHello(name)?.count ?: 0

}