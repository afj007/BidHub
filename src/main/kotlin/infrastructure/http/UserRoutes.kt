package br.com.estudo.infrastructure.http

import br.com.estudo.application.user.command.UserCreateRequest
import br.com.estudo.application.user.controller.UserController
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.userRoutes() {
    routing {
        val userController by inject<UserController>()

        route("/users") {
            get {
                call.respond(userController.getAll())
            }

            post {
                val request = call.receive<UserCreateRequest>()
                call.respond(userController.create(request))
            }
        }

    }
}