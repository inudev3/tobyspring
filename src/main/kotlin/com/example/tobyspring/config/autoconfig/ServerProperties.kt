package com.example.tobyspring.config.autoconfig

import com.example.tobyspring.config.annotation.MyConfigurationProperties
import org.springframework.stereotype.Component

@Component
@MyConfigurationProperties(prefix = "server")
class ServerProperties(val contextPath:String, val port:Int)


