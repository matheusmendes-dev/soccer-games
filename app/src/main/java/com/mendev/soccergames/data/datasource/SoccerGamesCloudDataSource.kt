package com.mendev.soccergames.data.datasource

import com.haroldadmin.cnradapter.NetworkResponse
import com.mendev.soccergames.championships.model.Championship
import com.mendev.soccergames.data.repository.SoccerGamesApiClient
import javax.inject.Inject

class SoccerGamesCloudDataSource @Inject constructor(
    private val apiClient: SoccerGamesApiClient
) : SoccerGamesDataSource {

    override suspend fun getChampionships(): List<Championship> {
        return when (val response = apiClient.getChampionships()) {
            is NetworkResponse.Success -> {
                response.body
            }
            is NetworkResponse.ServerError -> {
                listOf()
            }
            else -> listOf()
        }
    }
}