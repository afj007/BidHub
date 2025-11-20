package br.com.estudo.infrastructure.ktor.modules

import br.com.estudo.application.user.controller.UserController
import br.com.estudo.domain.user.repository.UserRepository
import br.com.estudo.infrastructure.database.repository.UserRepositoryImpl
import br.com.estudo.domain.user.service.UserService
import br.com.estudo.infrastructure.database.configureDatabase
import io.ktor.server.application.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureFrameworks() {
    install(Koin) {
        slf4jLogger()
        modules(
            module {
                single { configureDatabase() }

                //Controller
                singleOf(::UserController)

                //Service
                singleOf(::UserService)


                //Repository
                singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
            }
        )
    }
}
