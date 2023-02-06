package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.MyAutoConfiguration
import com.example.tobyspring.config.annotation.MyConfigurationProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.core.env.Environment
import kotlin.reflect.javaType

@MyAutoConfiguration
class PropertyPostProcessorConfig {
    @Bean
    fun propertyPostProcessor(env:Environment):BeanPostProcessor{
        return object :BeanPostProcessor{
            override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
                val myConfigClass = MyConfigurationProperties::class
//                val myAutoConfig = MyAutoConfiguration::class

//                val autoAnnotation = AnnotationUtils.findAnnotation(bean::class.java, myAutoConfig.java)
                val configAnnotation  = AnnotationUtils.findAnnotation(bean::class.java, myConfigClass.java)
                configAnnotation?.let{
                    val attrs = AnnotationUtils.getAnnotationAttributes(it)
                    val prefix = attrs[myConfigClass.members.first().name] as String
                    return Binder.get(env).bindOrCreate(prefix, bean::class.java)
                } ?: return bean
            }
        }
    }
}