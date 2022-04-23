package com.devcraft.clean_architecture.model

data class League(
    val id: String,
    val name: String,
    val slug: String,
    val abbr: String,
    val logos: Logos
)
