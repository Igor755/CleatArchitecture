package com.devcraft.data.extensions

import com.devcraft.data.entity.network.GenericNet
import com.devcraft.data.entity.network.LeagueNet
import com.devcraft.data.entity.network.LeaguesNet
import com.devcraft.data.entity.network.LogosNet
import com.devcraft.data.entity.room.GenericEntity
import com.devcraft.domain.model.GenericModel
import com.devcraft.domain.model.LeagueModel
import com.devcraft.domain.model.LeaguesModel
import com.devcraft.domain.model.LogosModel

fun List<GenericNet>.mapGenericNet() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun GenericEntity.map() = GenericModel(id)

fun GenericNet.map() = GenericModel(id)

fun List<GenericEntity>.mapGenericEntity() = mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun List<GenericModel>.mapToGenericEntity() = mapTo(mutableListOf(), {
    it.map()
})

fun GenericModel.map() = GenericEntity(id)


fun LeaguesNet.map() = LeaguesModel(status,data.mapLeaguesNet())

fun List<LeagueNet>.mapLeaguesNet() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun LeagueNet.map() = LeagueModel(id, name, slug, abbr, logos.mapLogosNet())

fun LogosNet.mapLogosNet() = LogosModel(light, dark)






fun LeaguesModel.map() = LeaguesNet(status,data.mapLeaguesModel())

fun List<LeagueModel>.mapLeaguesModel() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun LeagueModel.map() = LeagueNet(id, name, slug, abbr, logos.mapLogosModel())

fun LogosModel.mapLogosModel() = LogosNet(light, dark)




