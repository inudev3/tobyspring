package com.example.tobyspring.study

import com.example.tobyspring.HelloBootTest
import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
import org.springframework.test.annotation.Rollback

@HelloBootTest

class JdbcTemplateTest @Autowired constructor(val jdbcTemplate: JdbcTemplate) {
    @BeforeEach
    fun init() {
        jdbcTemplate.execute(
            """
            create table if not exists hello(name varchar(50) primary key, count int)
        """.trimIndent()
        )
    }

    @Test
    fun insertAndQuery() {
        jdbcTemplate.update(
            """
            insert into  hello values (?, ?)
        """.trimIndent(), "Toby", 3
        )
        jdbcTemplate.update(
            """
            insert into  hello values (?, ?)
        """.trimIndent(), "Spring", 3
        )
        val count = jdbcTemplate.queryForObject("""select count(*) from hello """, Long::class.java)
        assertThat(count).isEqualTo(2L)
    }
    @Test
    fun insertAndQuery2() {
        jdbcTemplate.update(
            """
            insert into  hello values (?, ?)
        """.trimIndent(), "Toby", 3
        )
        jdbcTemplate.update(
            """
            insert into  hello values (?, ?)
        """.trimIndent(), "Spring", 3
        )
        val count = jdbcTemplate.queryForObject("""select count(*) from hello """, Long::class.java)
        assertThat(count).isEqualTo(2L)
    }

}