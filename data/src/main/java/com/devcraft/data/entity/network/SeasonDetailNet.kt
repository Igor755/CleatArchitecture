package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class SeasonDetailNet(
    @SerializedName("name")
    val name: String,
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("seasonDisplay")
    val seasonDisplay: String,
    @SerializedName("season")
    val season: Int,
    @SerializedName("standings")
    val standings: List<StandingNet>
)