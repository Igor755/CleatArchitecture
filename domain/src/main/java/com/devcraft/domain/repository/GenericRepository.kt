package com.devcraft.domain.repository

import com.devcraft.domain.model.GenericModel

interface GenericRepository {
    suspend fun getGenerics(
        onSuccess: (List<GenericModel>?) -> Unit,
        onError: ((Exception) -> Unit?)? = null
    )

    suspend fun insertGenerics(
        generic: List<GenericModel>,
        onError: ((Exception) -> Unit?)? = null
    )
}