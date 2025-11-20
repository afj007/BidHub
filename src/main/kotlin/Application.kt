package br.com.estudo

import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(factory = Netty, port = 8081) {
        module()
    }.start(true)
}

fun Application.module() {
    configureFrameworks()
    configureSerialization()
    configureRouting()
    configureDatabase()
}
