package com.example.tobyspring

import com.example.tobyspring.controller.HelloController
import com.example.tobyspring.service.HelloService
import com.example.tobyspring.service.HelloServiceImpl
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.context.support.GenericWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

@Configuration
class TobyspringApplication{
    @Bean
    fun helloController(helloService: HelloService) = HelloController(helloService)
    @Bean
    fun helloService():HelloService = HelloServiceImpl()
}

fun main(args: Array<String>) {

    object: AnnotationConfigWebApplicationContext( ){
        @Suppress("INAPPLICABLE_JVM_NAME")
        @JvmName("myClassLoader")
        override fun setClassLoader(classLoader: ClassLoader) {
            this.classLoader=classLoader
        }

        override fun onRefresh() {
            super.onRefresh()
            TomcatServletWebServerFactory().getWebServer(ServletContextInitializer { servletContext ->
                servletContext.addServlet("dispatcherServlet", DispatcherServlet(this)).addMapping("/*")
            }).start()
        }
    }.also { it.register(TobyspringApplication::class.java);it.refresh()}.start()
}
