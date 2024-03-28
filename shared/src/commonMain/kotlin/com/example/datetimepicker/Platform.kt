package com.example.datetimepicker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform