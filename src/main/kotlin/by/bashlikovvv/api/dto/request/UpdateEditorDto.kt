package by.bashlikovvv.api.dto.request

import by.bashlikovvv.util.inRange
import kotlinx.serialization.Serializable
import kotlin.jvm.Throws

@Serializable
class UpdateEditorDto {

    @Serializable
    val login: String

    @Serializable
    val password: String

    @Serializable
    val firstname: String

    @Serializable
    val lastname: String

    @Throws(IllegalStateException::class)
    constructor(login: String, password: String, firstname: String, lastname: String) {
        if (!login.inRange(2, 64)) {
            throw IllegalStateException()
        }
        if (!password.inRange(8, 128)) {
            throw IllegalStateException()
        }
        if (!firstname.inRange(2, 64)) {
            throw IllegalStateException()
        }
        if (!lastname.inRange(2, 64)) {
            throw IllegalStateException()
        }

        this.login = login
        this.password = password
        this.firstname = firstname
        this.lastname = lastname
    }

}