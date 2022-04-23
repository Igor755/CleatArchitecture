package com.devcraft.data.api.service

import com.devcraft.data.entity.network.LeaguesNet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface LeaguesApi {
    @GET
    fun getLeagues(@Url url: String): Call<LeaguesNet>
}