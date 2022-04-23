package com.devcraft.data.entity.network

import com.google.gson.annotations.SerializedName

data class TeamNet (
    @SerializedName("id")
    val id: String,
    @SerializedName("uid")
    val uid: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("name")
    val name: Int,
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("displayName")
    val displayName: Int,
    @SerializedName("shortDisplayName")
    val shortDisplayName: Int,
    @SerializedName("isActive")
    val isActive: Int,
    @SerializedName("logos")
    val logos: List<LogoNet>)
