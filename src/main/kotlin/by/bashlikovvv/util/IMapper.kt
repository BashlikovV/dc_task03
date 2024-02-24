package by.bashlikovvv.util

interface IMapper<Entity, Domain, Dto> {

    fun mapFromEntity(entity: Entity): Domain

    fun mapToEntity(domain: Domain): Entity

    fun mapToDto(entity: Entity): Dto

}