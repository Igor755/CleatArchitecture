package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class LeaguesNet(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: List<LeagueNet>
)
