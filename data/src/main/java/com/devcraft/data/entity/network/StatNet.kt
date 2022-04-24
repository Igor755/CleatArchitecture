package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class StatNet(
    @SerializedName("name")
    val name: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("shortDisplayName")
    val shortDisplayName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: Int,
    @SerializedName("displayValue")
    val displayValue: String,
    @SerializedName("id")
    val id: String?,
    @SerializedName("summary")
    val summary: String?
)
