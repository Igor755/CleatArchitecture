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
    val name: String,
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("shortDisplayName")
    val shortDisplayName: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("logos")
    val logos: List<LogoNet>)
