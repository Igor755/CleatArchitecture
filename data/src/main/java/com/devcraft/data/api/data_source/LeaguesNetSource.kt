package com.devcraft.data.api.data_source

import com.devcraft.data.api.service.LeaguesApi
import com.devcraft.data.constant.ApiEndpoints
import com.devcraft.data.entity.network.LeaguesNet
import com.devcraft.data.extensions.map
import com.devcraft.domain.exception.NetworkErrorException
import com.devcraft.domain.model.LeaguesModel
import com.devcraft.domain.throwException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeaguesNetSource (private val leaguesApi: LeaguesApi) {

    fun getLeagues(onComplete: (LeaguesModel?) -> Unit, onError: (Exception) -> Unit?) {
        leaguesApi.getLeagues().enqueue(object : Callback<LeaguesNet> {
                override fun onFailure(call: Call<LeaguesNet>, t: Throwable) {
                    onError(NetworkErrorException())
                }
                override fun onResponse(
                    call: Call<LeaguesNet>,
                    response: Response<LeaguesNet>
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