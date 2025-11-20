package br.com.estudo

import io.ktor.server.application.Application
import org.jetbrains.exposed.v1.jdbc.Database


fun Application.configureDatabase() {
    Database.connect(
        "jdbc:postgresql://localhost:5432/postgres",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "password"
    )
}