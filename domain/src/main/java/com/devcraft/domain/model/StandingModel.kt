package com.devcraft.domain.model

data class StandingModel(
    val team: TeamModel?,
    val note: NoteModel?,
    val stats: List<StatModel>?
)
