package com.example.tobyspring.study

import com.example.tobyspring.HelloBootTest
import com.example.tobyspring.helloBoot.repository.HelloRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

@HelloBootTest
class HelloRepositoryTest @Autowired constructor(private val helloRepository: HelloRepository, private val jdbcTemplate: JdbcTemplate){
    @BeforeEach
    fun init(){
        jdbcTemplate.execute("""create table if not exists hello (name varchar(50) primary key, count int)""")
    }
    @Test
    fun `find hello failed`(){
        assertThat(helloRepository.findHello("inu")).isEqualTo(null)
    }
    @Test
    fun `increaseCount`(){
        helloRepository.increaseCount("inu")
        assertThat(helloRepository.countOf("inu")).isEqualTo(1)
        helloRepository.increaseCount("inu")
        assertThat(helloRepository.countOf("inu")).isEqualTo(2)
    }
}