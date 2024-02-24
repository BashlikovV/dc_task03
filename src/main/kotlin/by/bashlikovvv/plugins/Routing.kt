package by.bashlikovvv.plugins

import by.bashlikovvv.plugins.routings.editorsRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        editorsRouting()
        tweetsRouting()
    }
}