package com.example.tobyspring.study

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ConfigurationTest {

    @Test
    fun configTest(){
        val config = Config()
        val bean1 = config.bean1()
        val bean2 = config.bean2()
        assertThat(bean1.common).isEqualTo(bean2.common)
    }

    @Test
    fun configRefreshTest(){
        val context = AnnotationConfigApplicationContext()
        context.register(Config::class.java)
        context.refresh()

        val bean1 = context.getBean(Bean1::class.java)
        val bean2 = context.getBean(Bean1::class.java)
        assertThat(bean1.common).isEqualTo(bean2.common)
    }
    @Test
    fun proxyTest(){
        val config = MyConfig()
        val bean1 = config.bean1()
        val bean2 = config.bean2()
        assertThat(bean1.common).isEqualTo(bean2.common)
    }
    class MyConfig:Config(){
        internal object UNINITIALIZED
        var value:Any? = UNINITIALIZED

        override fun common(): Common {
            if(this.value==UNINITIALIZED) this.value=super.common()
            return this.value as Common
        }
    }
    @Configuration
    open class Config{
        @Bean
        fun common():Common= Common()
        @Bean
        fun bean1():Bean1 = Bean1(common())
        @Bean
        fun bean2():Bean2 = Bean2(common())
    }
    class Bean1(val common:Common)
    class Bean2(val common:Common)
    class Common{}

}
