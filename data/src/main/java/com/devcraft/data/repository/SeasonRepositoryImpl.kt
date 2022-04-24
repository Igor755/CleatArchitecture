package com.devcraft.data.repository

import com.devcraft.data.api.data_source.SeasonNetSource
import com.devcraft.domain.model.SeasonModel
import com.devcraft.domain.repository.SeasonRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class SeasonRepositoryImpl : SeasonRepository, KoinComponent {

    private val seasonNetSource: SeasonNetSource by inject()

    override suspend fun getSeason(
        id: String,
        onComplete: (SeasonModel?) -> Unit,
        onError: ((Exception) -> Unit?)?
    ) {
        seasonNetSource.getSeason(id,{
            onComplete(it)
        }, {
            onError?.invoke(it)
        })
    }
}