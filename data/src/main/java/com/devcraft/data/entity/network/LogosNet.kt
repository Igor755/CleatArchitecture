package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class LogosNet(
    @SerializedName("light")
    val light: String,
    @SerializedName("dark")
    val dark: String
)
