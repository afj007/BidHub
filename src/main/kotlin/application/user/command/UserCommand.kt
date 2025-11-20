package br.com.estudo.application.user.command

import java.time.LocalDate
import java.util.UUID

data class UserCreateRequest(
    val name: String,
    val email: String,
    val dateOfBirth: LocalDate
)

data class UserResponse(
    val id: UUID,
    val name: String,
    val email: String,
    val dateOfBirth: LocalDate
)