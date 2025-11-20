package br.com.estudo.infrastructure.config

import org.jetbrains.exposed.v1.jdbc.Database


fun configureDatabase(): Database =
    Database.connect(
        "jdbc:postgresql://localhost:5432/postgres",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "password"
    )