package com.devcraft.data.extensions

import com.devcraft.data.entity.network.*
import com.devcraft.data.entity.room.GenericEntity
import com.devcraft.domain.model.*
import com.google.gson.annotations.SerializedName

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
        it.mapToLeague()
    }
)

fun LeagueNet.mapToLeague() = LeagueModel(id, name, slug, abbr, logos.mapLogosNet())

fun LogosNet.mapLogosNet() = LogosModel(light, dark)






fun LeaguesModel.map() = LeaguesNet(status,data.mapLeaguesModel())

fun List<LeagueModel>.mapLeaguesModel() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun LeagueModel.map() = LeagueNet(id, name, slug, abbr, logos.mapLogosModel())

fun LogosModel.mapLogosModel() = LogosNet(light, dark)





fun SeasonNet.map() = SeasonModel(status, data.map())

fun SeasonDetailNet.map() = SeasonDetailModel(name, abbreviation, seasonDisplay, season, standings.mapToStandings())

fun List<StandingNet>.mapToStandings() = this.mapTo(
    mutableListOf(), {
        it.mapStading()
    }
)

fun List<StatNet>.mapToStat() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun List<LogoNet>.mapToLogo() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)


fun StandingNet.mapStading() = StandingModel(team.mapToTeam(), note.map(), stats.mapToStat())

fun TeamNet.mapToTeam() = TeamModel(id, uid, location, name, abbreviation, displayName, shortDisplayName, isActive, logos.mapToLogo())

fun LogoNet.map() = LogoModel(href, width, height, alt,rel, lastUpdated)

fun StatNet.map() = StatModel(name, displayName, shortDisplayName, description, abbreviation, type, value, displayValue, id, summary)

fun NoteNet.map() = NoteModel(color, description.mapLeaguesNet(), rank)









fun SeasonModel.map() = SeasonNet(status, data.map())

fun SeasonDetailModel.map() = SeasonDetailNet(name, abbreviation, seasonDisplay, season, standings.mapToStandingsModel())

fun List<StandingModel>.mapToStandingsModel() = this.mapTo(
    mutableListOf(), {
        it.mapStading()
    }
)

fun List<StatModel>.mapToStatModel() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun List<LogoModel>.mapToLogoModel() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)


fun StandingModel.mapStading() = StandingNet(team.mapToTeam(), note.map(), stats.mapToStatModel())

fun TeamModel.mapToTeam() = TeamNet(id, uid, location, name, abbreviation, displayName, shortDisplayName, isActive, logos.mapToLogoModel())

fun LogoModel.map() = LogoNet(href, width, height, alt,rel, lastUpdated)

fun StatModel.map() = StatNet(name, displayName, shortDisplayName, description, abbreviation, type, value, displayValue, id, summary)

fun NoteModel.map() = NoteNet(color, description.mapLeaguesModel(), rank)


