package com.example.tobyspring.config.annotation

import com.example.tobyspring.config.MyImportSelect
import com.example.tobyspring.config.autoconfig.DisPatcherServletConfig
import com.example.tobyspring.config.autoconfig.TomCatWebServerConfig
import org.springframework.boot.autoconfigure.AutoConfigurationPackage
import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.ANNOTATION_CLASS)
@Import(MyImportSelect::class)
annotation class EnableMyAutoConfiguration {
}