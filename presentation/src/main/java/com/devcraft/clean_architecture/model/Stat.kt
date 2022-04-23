package com.devcraft.clean_architecture.model

data class Stat(
    val name: String,
    val displayName: String,
    val shortDisplayName: String,
    val description: String,
    val abbreviation: String,
    val type: String,
    val value: String,
    val displayValue: Int,
    val id: String,
    val summary: String
)
