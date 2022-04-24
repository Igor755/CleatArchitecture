package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class SeasonNet(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("data")
    val data: SeasonDetailNet
)
