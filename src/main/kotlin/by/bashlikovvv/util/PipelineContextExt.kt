package by.bashlikovvv.util

import io.ktor.server.application.*
import io.ktor.util.pipeline.*

suspend fun PipelineContext<Unit, ApplicationCall>.respond(
    isCorrect: () -> Boolean,
    onCorrect: suspend () -> Unit,
    onIncorrect: suspend () -> Unit
) {
    if (isCorrect()) {
        onCorrect()
    } else {
        onIncorrect()
    }
}