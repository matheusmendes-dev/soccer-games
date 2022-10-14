package com.mendev.soccergames.data.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.mendev.soccergames.championships.model.Championship
import com.mendev.soccergames.data.model.ErrorResponse
import retrofit2.http.GET

interface SoccerGamesApiClient {

    @GET("campeonatos")
    suspend fun getChampionships(): NetworkResponse<List<Championship>, ErrorResponse>

}