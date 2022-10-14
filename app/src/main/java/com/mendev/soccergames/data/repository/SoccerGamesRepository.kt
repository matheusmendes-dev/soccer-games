package com.mendev.soccergames.data.repository

import com.mendev.soccergames.championships.model.Championship
import com.mendev.soccergames.data.datasource.SoccerGamesDataSource
import javax.inject.Inject

interface SoccerGamesRepository {

    suspend fun getChampionships(): List<Championship>

}

class SoccerGamesRepositoryImpl @Inject constructor(
    private val cloudDataSource: SoccerGamesDataSource
) : SoccerGamesRepository {

    override suspend fun getChampionships(): List<Championship> {
        return cloudDataSource.getChampionships()
    }

}