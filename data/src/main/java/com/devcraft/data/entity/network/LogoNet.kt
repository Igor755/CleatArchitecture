package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class LogoNet(
    @SerializedName("href")
    val href: String,
    @SerializedName("width")
    val width: Int ,
    @SerializedName("height")
    val height: Int,
    @SerializedName("alt")
    val alt: String,
    @SerializedName("rel")
    val rel: List<String>,
    @SerializedName("lastUpdated")
    val lastUpdated: String
)
