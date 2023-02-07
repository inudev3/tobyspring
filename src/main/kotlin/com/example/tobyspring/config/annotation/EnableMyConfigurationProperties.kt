package com.example.tobyspring.config.annotation

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.context.annotation.Import
import org.springframework.core.type.AnnotationMetadata
import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(EnableMyConfigurationProperties.MyConfiguratinoPropertiesImportSelector::class)
annotation class EnableMyConfigurationProperties(val value: KClass<*>) {
    class MyConfiguratinoPropertiesImportSelector:DeferredImportSelector{
        override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
            val enableClass = EnableMyConfigurationProperties::class
            val attr=importingClassMetadata.getAllAnnotationAttributes(enableClass.jvmName)?: return arrayOf()
            return (attr["value"]!! as MutableList<Class<*>>).map{it.name}.toTypedArray()
        }

    }
}
