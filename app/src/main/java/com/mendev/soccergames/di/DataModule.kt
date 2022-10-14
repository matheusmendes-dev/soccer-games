package com.mendev.soccergames.di

import com.mendev.soccergames.data.datasource.SoccerGamesCloudDataSource
import com.mendev.soccergames.data.datasource.SoccerGamesDataSource
import com.mendev.soccergames.data.repository.SoccerGamesRepository
import com.mendev.soccergames.data.repository.SoccerGamesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindSoccerGamesRepository(
        repositoryImpl: SoccerGamesRepositoryImpl
    ): SoccerGamesRepository

    @Singleton
    @Binds
    abstract fun bindSoccerGamesCloudDataSource(
        cloudDataSource: SoccerGamesCloudDataSource
    ): SoccerGamesDataSource
}