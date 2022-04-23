package com.devcraft.data.repository

import com.devcraft.data.api.data_source.LeaguesNetSource
import com.devcraft.domain.model.LeaguesModel
import com.devcraft.domain.repository.LeaguesRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class LeaguesRepositoryImpl : LeaguesRepository, KoinComponent {

    private val leaguesNetSource: LeaguesNetSource by inject()

    override suspend fun getLeagues(
        onComplete: (LeaguesModel?) -> Unit,
        onError: ((Exception) -> Unit?)?
    ) {
        leaguesNetSource.getLeagues({
            onComplete(it)
        }, {
            onError?.invoke(it)
        })
    }
}