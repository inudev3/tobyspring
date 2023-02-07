package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.MyConfigurationProperties
import org.springframework.stereotype.Component

@Component
@MyConfigurationProperties("data")
class MyDataSourceProperties(val driverClassName:String, val url:String, val username:String, val pw:String)
