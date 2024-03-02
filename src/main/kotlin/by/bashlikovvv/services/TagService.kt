package by.bashlikovvv.services

import by.bashlikovvv.api.dto.request.CreateTagDto
import by.bashlikovvv.api.dto.request.UpdateTagDto
import by.bashlikovvv.domain.model.Tag

interface TagService {

    suspend fun create(createTagDto: CreateTagDto): Tag?

    suspend fun getAll(): List<Tag?>

    suspend fun getById(tagId: Long): Tag?

    suspend fun update(tagId: Long, updateTagDto: UpdateTagDto): Tag?

    suspend fun delete(tagId: Long): Boolean

}