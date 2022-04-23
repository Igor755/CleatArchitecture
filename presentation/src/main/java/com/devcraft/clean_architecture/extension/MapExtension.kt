package com.devcraft.clean_architecture.extension

import com.devcraft.clean_architecture.model.Generic
import com.devcraft.clean_architecture.model.League
import com.devcraft.clean_architecture.model.Leagues
import com.devcraft.clean_architecture.model.Logos
import com.devcraft.domain.model.GenericModel
import com.devcraft.domain.model.LeagueModel
import com.devcraft.domain.model.LeaguesModel
import com.devcraft.domain.model.LogosModel

fun List<GenericModel>.mapGeneric() = this.mapTo(mutableListOf(), {
    it.map()
})

fun GenericModel.map() = Generic(
    id = id
)


fun Leagues.map() = LeaguesModel(status, league.mapLeagues())

fun List<League>.mapLeagues() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun League.map() = LeagueModel(id, name, slug, abbr, logos.mapLogos())

fun Logos.mapLogos() = LogosModel(light, dark)






fun LeaguesModel.mapto() = Leagues(status,data.mapLeaguesModel())

fun List<LeagueModel>.mapLeaguesModel() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun LeagueModel.map() = League(id, name, slug, abbr, logos.mapLogosModel())

fun LogosModel.mapLogosModel() = Logos(light, dark)