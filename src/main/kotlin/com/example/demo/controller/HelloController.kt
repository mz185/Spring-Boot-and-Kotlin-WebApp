package com.example.demo.controller

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
        model: Model
    ): String {
        val greeting = String.format("Hello %s!", name)
        model["greeting"] = greeting
        return String.format("Hello %s!", name)
    }
}