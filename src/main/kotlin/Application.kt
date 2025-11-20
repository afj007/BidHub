package br.com.estudo

import br.com.estudo.infrastructure.ktor.modules.configureFrameworks
import br.com.estudo.infrastructure.ktor.modules.configureRouting
import br.com.estudo.infrastructure.ktor.modules.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8081) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    configureFrameworks()
    configureSerialization()
    configureRouting()
}

