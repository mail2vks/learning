package com.example.hitCounter

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.support.SpringBootServletInitializer

@SpringBootApplication
class HitCounterApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    SpringApplication.run(HitCounterApplication::class.java);
}
