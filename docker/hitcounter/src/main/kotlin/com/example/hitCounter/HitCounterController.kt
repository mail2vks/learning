package com.example.hitCounter

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.beans.factory.annotation.Autowired

@RestController
class HitCounterController {

    @Autowired
    private val template: RedisTemplate<String, String>? = null

    @RequestMapping fun getCounter(): String {
        return "I have seen this " + template!!.boundHashOps<String, String>("HitCounterHash").increment("HitCounterKey", 1)
    }

}
