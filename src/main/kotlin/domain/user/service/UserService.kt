package br.com.estudo.domain.user.service

import br.com.estudo.domain.user.entity.User
import br.com.estudo.domain.user.repository.UserRepository

class UserService(
    private val userRepository: UserRepository
) {

    suspend fun getAll(): List<User> {
        return userRepository.getAll()
    }
}