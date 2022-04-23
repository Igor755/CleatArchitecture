package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class LeagueNet(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("abbr")
    val abbr: String,
    @SerializedName("logos")
    val logos: LogosNet
)
