package br.com.estudo.infrastructure.database.table

import org.jetbrains.exposed.v1.core.dao.id.UUIDTable
import org.jetbrains.exposed.v1.javatime.date

const val MAX_VARCHAR_LENGTH = 100

object UserTable: UUIDTable(name = "users") {
    val name = varchar("name", MAX_VARCHAR_LENGTH)
    val email = varchar("email", MAX_VARCHAR_LENGTH)
    val dateOfBirth = date("date_of_birth")

}