package com.devcraft.domain.repository

import com.devcraft.domain.model.SeasonModel

interface StandingsRepository {
    suspend fun getStandings(id: String, onComplete: (SeasonModel?) -> Unit,
                             onError: ((Exception) -> Unit?)?)
}