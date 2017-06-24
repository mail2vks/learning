package com.example.hitCounter

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
@PropertySource("application.properties")
class RedisConfig {

    @Value("\${spring.redis.host}")
    private val redisHostName: String? = null

    @Bean
    fun getJedisConnectionFactory(): JedisConnectionFactory {
        val cf = JedisConnectionFactory()
        cf.hostName = redisHostName
        return cf
    }

}
