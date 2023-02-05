package com.example.tobyspring

import com.example.tobyspring.helloBoot.controller.HelloController
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class HelloControllerTest {
    @Test
    fun helloControllerTest(){
        val controller = HelloController{ name->
            "hello $name"
        }
        val txt = "Spring"
        val res=controller.hello(txt)
        assertThat(res).isEqualTo("hello $txt")
    }
    @Test
    fun `helloController fails with blank argument`(){
        val controller = HelloController{ name->
            "hello $name"
        }
        assertThatThrownBy {  controller.hello("")}.isInstanceOf(IllegalArgumentException::class.java)
    }
}