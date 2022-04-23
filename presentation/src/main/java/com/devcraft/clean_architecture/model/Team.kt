package com.devcraft.clean_architecture.model

data class Team (
    val id: String,
    val uid: String,
    val location: String,
    val name: Int,
    val abbreviation: String,
    val displayName: Int,
    val shortDisplayName: Int,
    val isActive: Int,
    val logos: List<Logo>)
