package com.devcraft.domain.interactor

import com.devcraft.domain.model.GenericModel
import com.devcraft.domain.repository.GenericRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class GenericInteractor : KoinComponent {
    private val repository: GenericRepository by inject()
    suspend fun getGeneric(
        onSuccess: (List<GenericModel>?) -> Unit,
        onError: ((Exception) -> Unit?)?
    ) {
        return repository.getGenerics(onSuccess, onError)
    }

    suspend fun insertGeneric(
        generics: List<GenericModel>,
        onError: ((Exception) -> Unit?)? = null
    ) {
        repository.insertGenerics(generics, onError = onError)
    }
}