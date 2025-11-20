package br.com.estudo.domain.user.repository

import br.com.estudo.domain.user.entity.User

interface UserRepository {

    suspend fun getAll(): List<User>
}