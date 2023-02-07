package com.example.tobyspring.helloBoot.repository

import com.example.tobyspring.helloBoot.domain.Hello
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class HelloRepositoryImpl(private val jdbcTemplate: JdbcTemplate) : HelloRepository {
    override fun findHello(name: String): Hello? = try{
        jdbcTemplate.queryForObject("""select * from hello where name = '$name'""") { rs, rowNim ->
            Hello(rs.getString("name"), rs.getInt("count"))
        }
    } catch (ex:EmptyResultDataAccessException){null}



    override fun increaseCount(name: String){
        findHello(name)?.let{
            jdbcTemplate.update("""update hello set count = ? where name= ?""", it.count+1, name)
            return
        }?: run {
            jdbcTemplate.update("""insert into hello values (?,?)""", name, 1)
            return
        }

    }
}
