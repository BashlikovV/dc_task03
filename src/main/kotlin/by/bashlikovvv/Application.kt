package by.bashlikovvv

import by.bashlikovvv.di.appModule
import by.bashlikovvv.di.dataModule
import by.bashlikovvv.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.client.HttpClient
import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.network.tls.*
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.koin.ktor.plugin.Koin
import java.security.KeyStore
import java.security.SecureRandom
import javax.net.ssl.TrustManager

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(Koin) {
        modules(dataModule, appModule)
    }
    configureSerialization()
    configureDatabases()
    configureRouting()
}
