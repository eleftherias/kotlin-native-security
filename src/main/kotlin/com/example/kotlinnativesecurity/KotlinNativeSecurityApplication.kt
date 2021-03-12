package com.example.kotlinnativesecurity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KotlinNativeSecurityApplication

fun main(args: Array<String>) {
	runApplication<KotlinNativeSecurityApplication>(*args)
}

@RestController
class BaseController {
	@GetMapping("/hello")
	fun hello(): String {
		return "Hello! Happy Tuesday!"
	}

	@GetMapping("/talk/info")
	fun info(): String {
		return "Turning Kotlin Applications into Secure Native Executables on March 16, 2021."
	}
}