package com.devcraft.clean_architecture.extension

import com.devcraft.clean_architecture.model.*
import com.devcraft.domain.model.*

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















fun Season.map() = SeasonModel(status, data.map())

fun SeasonDetail.map() = SeasonDetailModel(
    name,
    abbreviation,
    seasonDisplay,
    season,
    standings.mapToStandings()
)

fun List<Standing>.mapToStandings() = this.mapTo(
    mutableListOf(), {
        it.mapStading()
    }
)

fun List<Stat>.mapToStat() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun List<Logo>.mapToLogo() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)


fun Standing.mapStading() = StandingModel(team.mapToTeam(), note.map(), stats.mapToStat())

fun Team.mapToTeam() = TeamModel(
    id,
    uid,
    location,
    name,
    abbreviation,
    displayName,
    shortDisplayName,
    isActive,
    logos.mapToLogo()
)

fun Logo.map() = LogoModel(href, width, height, alt, rel, lastUpdated)

fun Stat.map() = StatModel(
    name,
    displayName,
    shortDisplayName,
    description,
    abbreviation,
    type,
    value,
    displayValue,
    id,
    summary
)

fun Note.map() = NoteModel(color, description.mapLeagues(), rank)









fun SeasonModel.map() = Season(status, data.map())

fun SeasonDetailModel.map() = SeasonDetail(name, abbreviation, seasonDisplay, season, standings.mapToStandingsModel())

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


fun StandingModel.mapStading() = Standing(team.mapToTeam(), note.map(), stats.mapToStatModel())

fun TeamModel.mapToTeam() = Team(id, uid, location, name, abbreviation, displayName, shortDisplayName, isActive, logos.mapToLogoModel())

fun LogoModel.map() = Logo(href, width, height, alt,rel, lastUpdated)

fun StatModel.map() = Stat(name, displayName, shortDisplayName, description, abbreviation, type, value, displayValue, id, summary)

fun NoteModel.map() = Note(color, description.mapLeaguesModel(), rank)