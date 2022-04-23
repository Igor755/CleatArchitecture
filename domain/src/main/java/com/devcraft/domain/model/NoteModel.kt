package com.devcraft.domain.model

data class NoteModel (
    val color: String,
    val description: List<LeagueModel>,
    val rank: Int)
