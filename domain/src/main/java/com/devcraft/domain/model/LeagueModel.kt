package com.devcraft.domain.model

data class LeagueModel(
    val id: String,
    val name: String,
    val slug: String,
    val abbr: String,
    val logos: LogosModel
)
