package com.devcraft.clean_architecture.model

data class Stat(
    val name: String,
    val displayName: String,
    val shortDisplayName: String,
    val description: String,
    val abbreviation: String,
    val type: String,
    val value: Int,
    val displayValue: String,
    val id: String?,
    val summary: String?
)
