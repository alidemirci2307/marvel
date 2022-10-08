package com.demirci.marvel.di

import com.demirci.marvel.data.repository.MarvelRepositoryImpl
import com.demirci.marvel.data.source.MarvelApi
import com.demirci.marvel.domain.repository.MarvelRepository
import com.demirci.marvel.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMarvelApi(): MarvelApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(MarvelApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMarvelRepository(api : MarvelApi) : MarvelRepository {
        return MarvelRepositoryImpl(api)
    }
}