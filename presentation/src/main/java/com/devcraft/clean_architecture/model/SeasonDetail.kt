package com.devcraft.clean_architecture.model

data class SeasonDetail(
    val name: String,
    val abbreviation: String,
    val seasonDisplay: String,
    val season: Int,
    val standings: List<Standing>
)