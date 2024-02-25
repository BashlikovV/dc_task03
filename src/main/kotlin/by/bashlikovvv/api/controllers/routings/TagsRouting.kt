package by.bashlikovvv.api.controllers.routings

import by.bashlikovvv.api.dto.mappers.TagMapper
import by.bashlikovvv.api.dto.request.CreateTagDto
import by.bashlikovvv.api.dto.request.UpdateTagDto
import by.bashlikovvv.model.Response
import by.bashlikovvv.model.Tag
import by.bashlikovvv.services.TagService
import by.bashlikovvv.util.getWithCheck
import by.bashlikovvv.util.respond
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.tagsRouting() {
    val tagsService: TagService by inject()
    
    getTags(tagsService)
    createTag(tagsService)
    deleteTagById(tagsService)
    getTagById(tagsService)
    updateTag(tagsService)
}

private fun Route.getTags(tagsService: TagService) {
    get("/api/v1.0/tags") {
        val tags = tagsService.getAll()

        respond(
            isCorrect = { tags.isNotEmpty() },
            onCorrect = { call.respond(status = HttpStatusCode.OK, tags) },
            onIncorrect = {
                call.respond(status = HttpStatusCode.OK, Response(HttpStatusCode.OK.value))
            }
        )
    }
}

private fun Route.createTag(tagsService: TagService) {
    post("/api/v1.0/tags") {
        val createTagDto: CreateTagDto = call.receive()
        val addedTag = getWithCheck { tagsService.create(createTagDto) }

        respond(
            isCorrect = { addedTag != null },
            onCorrect = {
                call.respond(
                    status = HttpStatusCode.Created,
                    message = addedTag!!
                )
            },
            onIncorrect = {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = Response(HttpStatusCode.BadRequest.value)
                )
            }
        )
    }
}

private fun Route.deleteTagById(tagsService: TagService) {
    delete("/api/v1.0/tags/{id?}") {
        val id = call.parameters["id"] ?: return@delete call.respond(
            status = HttpStatusCode.BadRequest,
            message = Response(HttpStatusCode.BadRequest.value)
        )
        val removedItem = tagsService.delete(id.toLong())

        respond(
            isCorrect = { removedItem },
            onCorrect = {
                call.respond(status = HttpStatusCode.NoContent, Response(HttpStatusCode.OK.value))
            },
            onIncorrect = {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = Response(HttpStatusCode.BadRequest.value)
                )
            }
        )
    }
}

private fun Route.getTagById(tagsService: TagService) {
    get("/api/v1.0/tags/{id?}") {
        val id = call.parameters["id"] ?: return@get call.respond(
            status = HttpStatusCode.BadRequest,
            message = Response(HttpStatusCode.BadRequest.value)
        )
        val requestedItem = tagsService.getById(id.toLong())

        respond(
            isCorrect = { requestedItem != null },
            onCorrect = {
                call.respond(status = HttpStatusCode.OK, requestedItem!!)
            },
            onIncorrect = {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = Response(HttpStatusCode.BadRequest.value)
                )
            }
        )
    }
}

private fun Route.updateTag(tagsService: TagService) {
    put("/api/v1.0/tags") {
        val tag: UpdateTagDto = getWithCheck { call.receive() } ?: return@put call.respond(
            status = HttpStatusCode.BadRequest,
            message = Response(HttpStatusCode.BadRequest.value)
        )
        val mapper = TagMapper(tag.id, tag.tweetId)

        val updatedTag = tagsService.update(
            tagId = tag.id,
            updateTagDto = getWithCheck { mapper.mapFromEntity(Tag(tag.id, tag.name)) } ?: return@put call.respond(
                status = HttpStatusCode.BadRequest,
                message = Response(HttpStatusCode.BadRequest.value)
            )
        )

        respond(
            isCorrect = { updatedTag != null },
            onCorrect = {
                call.respond(
                    status = HttpStatusCode.OK,
                    message = updatedTag!!
                )
            },
            onIncorrect = {
                call.respond(
                    status = HttpStatusCode.BadRequest,
                    message = Response(HttpStatusCode.BadRequest.value)
                )
            }
        )
    }
}