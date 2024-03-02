package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.request.CreateTagDto
import by.bashlikovvv.api.dto.request.UpdateTagDto
import by.bashlikovvv.data.mapper.CreateTagDtoToTagMapper
import by.bashlikovvv.data.mapper.UpdateTagDtoToTagMapper
import by.bashlikovvv.domain.model.Tag
import by.bashlikovvv.domain.repository.ITagsRepository
import by.bashlikovvv.services.TagService

class TagServiceImpl(
    private val tagsRepository: ITagsRepository
) : TagService {
    override suspend fun create(createTagDto: CreateTagDto): Tag {
        val tag = CreateTagDtoToTagMapper().mapFromEntity(createTagDto)
        val id = tagsRepository.create(tag)

        return tag.copy(id = id)
    }

    override suspend fun getAll(): List<Tag?> {
        return tagsRepository.readAll()
    }

    override suspend fun getById(tagId: Long): Tag? {
        return tagsRepository.read(tagId)
    }

    override suspend fun update(tagId: Long, updateTagDto: UpdateTagDto): Tag {
        val tag = UpdateTagDtoToTagMapper().mapFromEntity(updateTagDto)
        if (!tagsRepository.update(tagId, tag)) {

        }

        return tag
    }

    override suspend fun delete(tagId: Long): Boolean {
        return tagsRepository.delete(tagId)
    }

}