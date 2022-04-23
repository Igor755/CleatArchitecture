package com.devcraft.clean_architecture.model

data class Standing(
    val team: Team,
    val note: Note,
    val stats: List<Stat>
)
