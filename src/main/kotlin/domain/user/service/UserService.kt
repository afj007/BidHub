package br.com.estudo.domain.user.service

import br.com.estudo.domain.user.entity.User
import br.com.estudo.domain.user.repository.UserRepository
import java.time.LocalDate
import java.util.UUID

class UserService(
    private val userRepository: UserRepository
) {

    suspend fun getAll(): List<User> {
        return userRepository.getAll()
    }

    suspend fun create(name: String, email: String, dateOfBirth: LocalDate): User {
        val user = User(
            id = UUID.randomUUID(),
            name = name,
            email = email,
            dateOfBirth = dateOfBirth
        )

        return userRepository.save(user)
    }
}