package com.devcraft.domain.model

data class StatModel(
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
