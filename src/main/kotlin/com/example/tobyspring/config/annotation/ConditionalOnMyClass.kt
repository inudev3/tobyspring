package com.example.tobyspring.config.annotation

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Conditional(MyClassCondition::class)
annotation class ConditionalOnMyClass(val value:String)

class MyClassCondition:Condition{
    val log = LoggerFactory.getLogger(MyClassCondition::class.java)
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val map = metadata.getAnnotationAttributes(ConditionalOnMyClass::class.java.name)

        val classname = map?.get( ConditionalOnMyClass::class.members.first().name) as? String ?: return false
        return ClassUtils.isPresent(classname, context.classLoader)
    }
}