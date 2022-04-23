package com.devcraft.domain.interactor

import com.devcraft.domain.model.LeaguesModel
import com.devcraft.domain.repository.LeaguesRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class LeaguesInteractor : KoinComponent  {

    private val leaguesRepository: LeaguesRepository by inject()

    suspend fun getLeagues(onSuccess: (LeaguesModel?) -> Unit,
                           onError: ((Exception) -> Unit?)?) = leaguesRepository.getLeagues(onSuccess,onError)
}