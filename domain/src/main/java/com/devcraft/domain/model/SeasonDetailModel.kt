package com.devcraft.domain.model

data class SeasonDetailModel(
    val name: String,
    val abbreviation: String,
    val seasonDisplay: String,
    val season: Int,
    val standings: List<StandingModel>
)