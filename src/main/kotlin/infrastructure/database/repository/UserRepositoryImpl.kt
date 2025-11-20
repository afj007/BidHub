package br.com.estudo.infrastructure.database.repository

import br.com.estudo.domain.user.entity.User
import br.com.estudo.domain.user.repository.UserRepository
import br.com.estudo.infrastructure.database.table.UserTable
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class UserRepositoryImpl(
    private val database: Database
) : UserRepository {

    override suspend fun getAll(): List<User> =
        transaction(database) {
            UserTable.selectAll().map {
                User(
                    id = it[UserTable.id].value,
                    name = it[UserTable.name],
                    email = it[UserTable.email],
                    dateOfBirth = it[UserTable.dateOfBirth]
                )
            }
        }
}