package com.example.tobyspring

import com.example.tobyspring.helloBoot.TobyspringApplication
import jakarta.transaction.Transactional
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@ContextConfiguration(classes = arrayOf(TobyspringApplication::class))
@SpringBootTest
//@ExtendWith(SpringExtension::class)
@TestPropertySource("classpath:/application.yml")
@Transactional
annotation class HelloBootTest
