package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class SeasonNet(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: SeasonDetailNet
)
