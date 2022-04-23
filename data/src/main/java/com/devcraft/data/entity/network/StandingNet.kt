package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class StandingNet(
    @SerializedName("team")
    val team: TeamNet,
    @SerializedName("note")
    val note: NoteNet,
    @SerializedName("stats")
    val stats: List<StatNet>
)
