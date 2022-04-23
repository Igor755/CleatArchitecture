package com.devcraft.data.api.service

import com.devcraft.data.entity.network.LeaguesNet
import com.devcraft.data.entity.network.SeasonNet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface LeaguesApi {
    @GET
    fun getLeagues(@Url url: String): Call<LeaguesNet>

    @GET
    fun getStandings(@Url url: String, @Path("id") id: String): Call<SeasonNet>
}