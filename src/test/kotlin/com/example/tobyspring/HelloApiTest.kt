package com.example.tobyspring


import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType


class HelloApiTest {
    @Test
    fun helloApi(){
        val template = TestRestTemplate()
        val str = "Spring"
        val res=template.getForEntity("http://localhost:8080/hello?name={name}", String::class.java, str)
        assertThat(res.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(res.headers.getFirst(HttpHeaders.CONTENT_TYPE)).contains(MediaType.TEXT_PLAIN_VALUE)
        assertThat(res.body).isEqualTo("*hello Spring*")
    }
    @Test
    fun `hello api fails because of blank argument`(){
        val template = TestRestTemplate()
        val str = ""
        val res=template.getForEntity("http://localhost:8080/hello?name={name}", String::class.java, str)
        assertThat(res.statusCode).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR)
//        assertThat(res.headers.getFirst(HttpHeaders.CONTENT_TYPE)).contains(MediaType.TEXT_PLAIN_VALUE)
//        assertThat(res.body).isEqualTo("hello Spring")
    }
}