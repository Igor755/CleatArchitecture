package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class NoteNet (
    @SerializedName("color")
    val color: String,
    @SerializedName("description")
    val description: List<LeagueNet>,
    @SerializedName("rank")
    val rank: Int)
