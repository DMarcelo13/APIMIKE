package com.example.apimike.retrofit

import com.example.apimike.model.Fox
import com.example.apimike.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<FoxNetworkEntity, Fox> {
    override fun mapFromEntity(entity: FoxNetworkEntity): Fox {
        return Fox(
            image = entity.image,
            link = entity.link,


        )
    }

    override fun mapToEntity(domainModel: Fox): FoxNetworkEntity {
        return FoxNetworkEntity(
            image = domainModel.image,
            link = domainModel.link,
        )
    }

    fun mapFromEntityList(entities: List<FoxNetworkEntity>): List<Fox>{
        return entities.map { mapFromEntity(it) }
    }
}