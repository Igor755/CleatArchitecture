package com.devcraft.data.api.data_source

import com.devcraft.data.api.service.LeaguesApi
import com.devcraft.data.constant.ApiEndpoints
import com.devcraft.data.entity.network.SeasonNet
import com.devcraft.data.extensions.map
import com.devcraft.domain.exception.NetworkErrorException
import com.devcraft.domain.model.SeasonModel
import com.devcraft.domain.throwException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeasonNetSource (private val leaguesApi: LeaguesApi) {
    fun getSeason(id : String, onComplete: (SeasonModel?) -> Unit, onError: (Exception) -> Unit?) {
        leaguesApi.getSeason(id).enqueue(object : Callback<SeasonNet> {
            override fun onFailure(call: Call<SeasonNet>, t: Throwable) {
                onError(NetworkErrorException())
            }
            override fun onResponse(
                call: Call<SeasonNet>,
                response: Response<SeasonNet>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onComplete(it.map())
                    }
                } else {
                    onError(response.code().throwException(response.message()))
                }
            }
        })
    }
}