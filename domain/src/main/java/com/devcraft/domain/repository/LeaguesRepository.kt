package com.devcraft.domain.repository

import com.devcraft.domain.model.LeaguesModel


interface LeaguesRepository {
    suspend fun getLeagues(onComplete: (LeaguesModel?) -> Unit,
                           onError: ((Exception) -> Unit?)?)
}