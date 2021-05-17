package com.example.apimike.room

import com.example.apimike.model.Fox
import com.example.apimike.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<FoxCacheEntity, Fox> {
    override fun mapFromEntity(entity: FoxCacheEntity): Fox {
        return Fox(
            image = entity.image,
            link = entity.link,
        )
    }

    override fun mapToEntity(domainModel: Fox): FoxCacheEntity {
        return FoxCacheEntity(
            image = domainModel.image,
            link = domainModel.link,
        )
    }

    fun mapFromEntityList(entities: List<FoxCacheEntity>): List<Fox>{
        return entities.map { mapFromEntity(it) }
    }
}
