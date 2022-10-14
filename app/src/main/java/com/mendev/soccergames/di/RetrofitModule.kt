package com.mendev.soccergames.di

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.mendev.soccergames.BuildConfig
import com.mendev.soccergames.data.repository.SoccerGamesApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideSoccerGamesApiClient(defaultHttpClient: OkHttpClient): SoccerGamesApiClient {
        return Retrofit.Builder()
            .baseUrl("https://api.api-futebol.com.br/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .client(defaultHttpClient)
            .build()
            .create(SoccerGamesApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(headerInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor.invoke { chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .addHeader("Authorization", BuildConfig.SOCCER_GAMES_API_KEY)
                    .build()
            )
        }
    }

}