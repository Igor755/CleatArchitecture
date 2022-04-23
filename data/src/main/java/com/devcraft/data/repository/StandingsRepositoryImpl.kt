package com.devcraft.data.repository

import com.devcraft.data.api.data_source.StandingsNetSource
import com.devcraft.domain.model.SeasonModel
import com.devcraft.domain.repository.StandingsRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class StandingsRepositoryImpl : StandingsRepository, KoinComponent {

    private val standingsNetSource: StandingsNetSource by inject()

    override suspend fun getStandings(
        id: String,
        onComplete: (SeasonModel?) -> Unit,
        onError: ((Exception) -> Unit?)?
    ) {
        standingsNetSource.getStandings(id,{
            onComplete(it)
        }, {
            onError?.invoke(it)
        })
    }
}