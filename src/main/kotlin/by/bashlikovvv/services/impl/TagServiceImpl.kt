package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.request.UpdateTagDto
import by.bashlikovvv.api.dto.response.TagDto
import by.bashlikovvv.services.TagService

class TagServiceImpl : TagService {
    override fun create(updateTagDto: UpdateTagDto): TagDto {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<TagDto> {
        TODO("Not yet implemented")
    }

    override fun getById(tagId: Long): TagDto {
        TODO("Not yet implemented")
    }

    override fun update(tagId: Long, updateTagDto: UpdateTagDto): TagDto {
        TODO("Not yet implemented")
    }

    override fun delete(tagId: Long): TagDto {
        TODO("Not yet implemented")
    }
}