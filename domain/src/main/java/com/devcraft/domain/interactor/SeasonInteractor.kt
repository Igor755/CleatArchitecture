package com.devcraft.domain.interactor

import com.devcraft.domain.model.SeasonModel
import com.devcraft.domain.repository.SeasonRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class SeasonInteractor  : KoinComponent {

    private val seasonRepository: SeasonRepository by inject()

    suspend fun getSeason(id:String, onSuccess: (SeasonModel?) -> Unit,
                          onError: ((Exception) -> Unit?)?) = seasonRepository.getSeason(id,onSuccess,onError)
}