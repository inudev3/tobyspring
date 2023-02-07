package com.example.tobyspring.study

import com.example.tobyspring.HelloBootTest
import com.example.tobyspring.helloBoot.TobyspringApplication
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.sql.DataSource
//
//@ExtendWith(SpringExtension::class)

@HelloBootTest
class DataSourceTest @Autowired constructor( val dataSource:DataSource){
    @Test
    fun connect(){
        dataSource.connection.close()
    }
}