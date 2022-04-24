package com.devcraft.clean_architecture.model

data class Team (
    val id: String,
    val uid: String,
    val location: String,
    val name: String,
    val abbreviation: String,
    val displayName: String,
    val shortDisplayName: String,
    val isActive: Boolean,
    val logos: List<Logo>)
