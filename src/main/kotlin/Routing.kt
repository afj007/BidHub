package br.com.estudo

import br.com.estudo.dao.UserTable
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.v1.core.StdOutSqlLogger
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import java.time.LocalDate
import java.util.*

fun Application.configureRouting() {
    routing {
        get {
            call.respond("Olá Mundo, to funfando!!")

            transaction {
                SchemaUtils.create(UserTable)
                addLogger(StdOutSqlLogger)

                val user = UserTable.insert {
                    it[id] = UUID.randomUUID()
                    it[name] = "Alan"
                    it[email] = "user@email.com"
                    it[dateOfBirth] = LocalDate.now().minusYears(10)
                }

            }

        }
        get("/all") {
        }
    }

}
