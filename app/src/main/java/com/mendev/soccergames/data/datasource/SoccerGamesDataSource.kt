package com.mendev.soccergames.data.datasource

import com.mendev.soccergames.championships.model.Championship

interface SoccerGamesDataSource {

    suspend fun getChampionships(): List<Championship>

}