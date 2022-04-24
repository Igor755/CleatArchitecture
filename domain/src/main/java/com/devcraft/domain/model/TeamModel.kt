package com.devcraft.domain.model

data class TeamModel (
    val id: String,
    val uid: String,
    val location: String,
    val name: String,
    val abbreviation: String,
    val displayName: String,
    val shortDisplayName: String,
    val isActive: Boolean,
    val logos: List<LogoModel>)
