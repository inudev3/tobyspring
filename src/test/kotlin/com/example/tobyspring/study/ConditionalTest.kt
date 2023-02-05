package com.example.tobyspring.study

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata
import kotlin.reflect.jvm.jvmName

class ConditionalTest {
    @Test
    fun conditional() {
        //true condtion
        val context = ApplicationContextRunner().withUserConfiguration(Config1::class.java).run { context ->
            assertThat(context).hasSingleBean(Config1::class.java)
            assertThat(context).hasSingleBean(MyBean::class.java)
        }
        //false condition
        val context2 = ApplicationContextRunner().withUserConfiguration(Config2::class.java).run { context->
            assertThat(context).doesNotHaveBean(Config2::class.java)
            assertThat(context).doesNotHaveBean(MyBean::class.java)
        }
    }


    @Conditional(BooleanCondition::class)
    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    annotation class BooleanConditional(val value:Boolean)

    @Configuration
    @BooleanConditional(true)
    class Config1(){
        @Bean
        fun myBean():MyBean = MyBean()
    }
    @Configuration
    @BooleanConditional(false)
    class Config2(){
        @Bean
        @Conditional()
        fun myBean():MyBean = MyBean()
    }
    class BooleanCondition:Condition{
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            val map = metadata.getAnnotationAttributes(BooleanConditional::class.jvmName)
            val key = BooleanConditional::class.members.first().name
            return (map?.get(key) as Boolean)
        }
    }
    class MyBean{}
}