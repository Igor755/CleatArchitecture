package com.devcraft.data.api.service

import com.devcraft.data.constant.ApiEndpoints
import com.devcraft.data.entity.network.LeaguesNet
import com.devcraft.data.entity.network.SeasonNet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface LeaguesApi {
    @GET(ApiEndpoints.GET_LEAGUES)
    fun getLeagues(): Call<LeaguesNet>

    @GET(ApiEndpoints.GET_STANDINGS)
    fun getSeason(@Path("id") id: String): Call<SeasonNet>
}