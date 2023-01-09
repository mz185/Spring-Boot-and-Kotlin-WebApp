package com.example.demo.model

data class UserGreeting(
    val name: String,
    val age: String
) {
    override fun toString(): String {
        return "$name $age"
    }
}
