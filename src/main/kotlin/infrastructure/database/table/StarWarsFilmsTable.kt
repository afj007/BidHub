package br.com.estudo.infrastructure.database.table

import org.jetbrains.exposed.v1.core.Table

object StarWarsFilmsTable : Table() {
    val id = integer("id").autoIncrement()
    val sequelId = integer("sequel_id").uniqueIndex()
    val name = varchar("name", MAX_VARCHAR_LENGTH)
    val director = varchar("director", MAX_VARCHAR_LENGTH)
}