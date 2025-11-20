package br.com.estudo.application.user.controller

import br.com.estudo.application.user.command.UserCreateRequest
import br.com.estudo.application.user.command.UserResponse
import br.com.estudo.domain.user.entity.User
import br.com.estudo.domain.user.service.UserService

class UserController(
    private val userService: UserService
) {

    suspend fun getAll(): List<User> {
        return userService.getAll()
    }

    suspend fun create(request: UserCreateRequest): UserResponse {
        val user = userService.create(name = request.name, email = request.email, dateOfBirth = request.dateOfBirth)

        return UserResponse(
            id = user.id,
            name = user.name,
            email = user.email,
            dateOfBirth = user.dateOfBirth
        )
    }
}