package by.bashlikovvv

import by.bashlikovvv.api.controllers.configureRouting
import by.bashlikovvv.api.controllers.configureSerialization
import by.bashlikovvv.di.appModule
import by.bashlikovvv.di.dataModule
import by.bashlikovvv.util.connectToPostgres
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import java.sql.Connection

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(Koin) {
        dataModule.single<Connection> { connectToPostgres(embedded = true) }
        modules(dataModule, appModule)
    }
    configureSerialization()
    configureRouting()
}
