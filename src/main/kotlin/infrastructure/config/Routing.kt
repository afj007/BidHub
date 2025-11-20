package br.com.estudo.infrastructure.config

import br.com.estudo.domain.user.service.UserService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    routing {
        val userService by inject<UserService>()

        get {
            call.respond(userService.getAll())
        }
    }

}
