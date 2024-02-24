package by.bashlikovvv.api.dto.request

import by.bashlikovvv.util.inRange
import kotlinx.serialization.Serializable
import kotlin.jvm.Throws

@Serializable
class UpdateTagDto {

    @Serializable
    private val name: String

    @Throws(IllegalStateException::class)
    constructor(name: String) {
        if (!name.inRange(2, 32)) { throw IllegalStateException() }

        this.name = name
    }

}