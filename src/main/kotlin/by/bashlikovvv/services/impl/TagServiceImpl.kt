package by.bashlikovvv.services.impl

import by.bashlikovvv.api.dto.mappers.TagMapper
import by.bashlikovvv.api.dto.request.CreateTagDto
import by.bashlikovvv.api.dto.request.UpdateTagDto
import by.bashlikovvv.api.dto.response.TagDto
import by.bashlikovvv.model.Tag
import by.bashlikovvv.services.TagService
import by.bashlikovvv.util.BaseRepository

class TagServiceImpl(
    private val tagsRepository: BaseRepository<TagDto, Long>
) : TagService {
    override fun create(createTagDto: CreateTagDto): TagDto? {
        val lastItemId = if (tagsRepository.data.isEmpty()) {
            -1
        } else {
            tagsRepository.getLastItem()?.id ?: return null
        }
        val mapper = TagMapper(lastItemId + 1, createTagDto.tweetId)
        val entity: Tag = mapper.mapToEntity(UpdateTagDto(
            lastItemId,
            createTagDto.tweetId,
            createTagDto.name
        ))
        val savedEntity = tagsRepository.addItem(lastItemId + 1, mapper.mapToDto(entity))

        return savedEntity
    }

    override fun getAll(): List<TagDto?> {
        return tagsRepository.data.map { it.second }
    }

    override fun getById(tagId: Long): TagDto? {
        return tagsRepository.getItemById(tagId)?.second
    }

    override fun update(tagId: Long, updateTagDto: UpdateTagDto): TagDto? {
        val tweetId = tagsRepository.getItemById(tagId)?.second?.tweetId ?: return null
        val mapper = TagMapper(tagId, tweetId)
        val entity: Tag = mapper.mapToEntity(updateTagDto)
        val savedEntity = tagsRepository.addItem(tagId, mapper.mapToDto(entity))

        return savedEntity
    }

    override fun delete(tagId: Long): Boolean {
        return tagsRepository.removeItem(tagId)
    }
}