package com.example.tobyspring.config.annotation


import com.example.tobyspring.config.autoconfig.DisPatcherServletConfig
import com.example.tobyspring.config.autoconfig.TomCatWebServerConfig
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.AutoConfigurationPackage
import org.springframework.boot.context.annotation.ImportCandidates
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.context.annotation.Import
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.core.type.AnnotationMetadata
import org.springframework.data.util.ReflectionUtils
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.jvm.jvmName

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.ANNOTATION_CLASS)
@Import(EnableMyAutoConfiguration.MyImportSelect::class)
annotation class EnableMyAutoConfiguration {
    class MyImportSelect(private val classLoader: ClassLoader) : DeferredImportSelector {

        override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {

//            MyAutoConfiguration::class.<>()
            val candidates:Iterable<String> = ImportCandidates.load(MyAutoConfiguration::class.java, classLoader)
//        candidates.forEach(logger::info)
            return candidates.toList().toTypedArray()
        }
    }
}