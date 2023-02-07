package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.ConditionalOnMyClass
import com.example.tobyspring.config.annotation.EnableMyConfigurationProperties
import com.example.tobyspring.config.annotation.MyAutoConfiguration
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import org.springframework.jdbc.support.JdbcTransactionManager
import java.sql.Driver
import javax.sql.DataSource


@MyAutoConfiguration
@ConditionalOnMyClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties::class)
class DataSourceConfig {
    @Bean
    @ConditionalOnMyClass("com.zaxxer.hikari.HikariDataSource")
    fun hikariDataSource(dataSourceProperties: MyDataSourceProperties): DataSource = HikariDataSource().also {
        it.driverClassName =  dataSourceProperties.driverClassName
        it.jdbcUrl= dataSourceProperties.url
        it.username = dataSourceProperties.username
        it.password = dataSourceProperties.pw
    }
    @Bean
    @ConditionalOnMissingBean
    fun dataSource(dataSourceProperties:MyDataSourceProperties):DataSource= SimpleDriverDataSource().also {
        val driverClass = Class.forName(dataSourceProperties.driverClassName) as? Class<out Driver>?: throw ClassNotFoundException()
        it.setDriverClass(driverClass)
        it.url= dataSourceProperties.url
        it.username = dataSourceProperties.username
        it.password = dataSourceProperties.pw
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnSingleCandidate(DataSource::class)
    fun jdbcTemplate(dataSource: DataSource):JdbcTemplate = JdbcTemplate(dataSource)

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnSingleCandidate(DataSource::class)
    fun jdbcTransactionManager(dataSource: DataSource):JdbcTransactionManager = JdbcTransactionManager(dataSource)

}