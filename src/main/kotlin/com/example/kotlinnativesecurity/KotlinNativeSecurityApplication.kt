package com.example.kotlinnativesecurity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.web.servlet.invoke
import org.springframework.web.servlet.function.router

@SpringBootApplication
class KotlinNativeSecurityApplication

fun main(args: Array<String>) {
    runApplication<KotlinNativeSecurityApplication>(*args) {
        addInitializers(
                beans {
                    bean {
                        router {
                            GET("/hello") { ok().body("Hello! Happy Tuesday!") }
                            "/talk".nest {
                                GET("/info") { ok().body("Turning Kotlin Applications into Secure Native Executables on March 16, 2021.") }
                            }
                        }
                    }
                    bean {
                        val http = ref<HttpSecurity>()
                        http {
                            authorizeRequests {
                                authorize("/hello", permitAll)
                                authorize(anyRequest, authenticated)
                            }
                            oauth2ResourceServer {
                                jwt {
                                    jwkSetUri = "http://host.docker.internal:9000/oauth2/jwks"
                                }
                            }
                        }
                        http.build()
                    }
                }
        )
    }
}