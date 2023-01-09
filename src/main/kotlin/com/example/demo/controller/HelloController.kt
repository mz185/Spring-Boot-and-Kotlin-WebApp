package com.example.demo.controller

import com.example.demo.model.UserGreeting
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("hello")
    fun hello(
        @RequestParam(value = "name", defaultValue = "stranger") name: String,
        @RequestParam(value = "age", defaultValue = "0") age: Int,
        model: Model
    ): String {
        val greeting = String.format("Hello %s!", name)
        model["greeting"] = greeting
        return UserGreeting(
            String.format("Hello %s!", name),
            String.format("Your age is %s.", age)
        ).toString()
    }
}