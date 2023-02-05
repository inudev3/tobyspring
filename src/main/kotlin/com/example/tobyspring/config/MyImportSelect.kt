package com.example.tobyspring.config

import com.example.tobyspring.config.annotation.MyAutoConfiguration
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.BeanClassLoaderAware
import org.springframework.boot.context.annotation.ImportCandidates
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.context.annotation.ImportSelector
import org.springframework.core.type.AnnotationMetadata
import java.util.stream.StreamSupport




class MyImportSelect(private val classLoader: ClassLoader) :DeferredImportSelector {
    val logger = LoggerFactory.getLogger(MyImportSelect::class.java)
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val candidates:Iterable<String> = ImportCandidates.load(MyAutoConfiguration::class.java, classLoader)
//        candidates.forEach(logger::info)
        return candidates.toList().toTypedArray()
    }
}