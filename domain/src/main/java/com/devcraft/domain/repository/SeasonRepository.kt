package com.devcraft.domain.repository

import com.devcraft.domain.model.SeasonModel

interface SeasonRepository {
    suspend fun getSeason(id: String, onComplete: (SeasonModel?) -> Unit,
                             onError: ((Exception) -> Unit?)?)
}