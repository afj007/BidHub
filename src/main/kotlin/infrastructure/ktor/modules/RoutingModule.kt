package br.com.estudo.infrastructure.ktor.modules

import br.com.estudo.infrastructure.http.userRoutes
import io.ktor.server.application.*

fun Application.configureRouting() {
    userRoutes()
}
