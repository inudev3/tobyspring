package com.example.tobyspring

import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class SpringApplication {
    companion object Context : AnnotationConfigWebApplicationContext() {
        @Suppress("INAPPLICABLE_JVM_NAME")
        @JvmName("myClassLoader")
        override fun setClassLoader(classLoader: ClassLoader) {
            this.classLoader = classLoader
        }


        override fun onRefresh() {
            val servletFactory = getBean(ServletWebServerFactory::class.java)
            val dispatcherServlet = getBean(DispatcherServlet::class.java)
            dispatcherServlet.setApplicationContext(this)
            super.onRefresh()
            servletFactory.getWebServer(ServletContextInitializer { servletContext ->
                servletContext.addServlet("dispatcherServlet", dispatcherServlet).addMapping("/*")
            }).start()
        }
        inline fun <reified T:Any>  runApplication(vararg args:String) {
           register(T::class.java)
            refresh()
        }
    }
}