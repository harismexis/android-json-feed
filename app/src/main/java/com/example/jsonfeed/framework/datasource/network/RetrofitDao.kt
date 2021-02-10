package com.example.jsonfeed.framework.datasource.network

import com.example.jsonfeed.BuildConfig
import com.example.jsonfeed.framework.datamodel.Feed

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitDao @Inject constructor() {

    private val api: PokemonApi

    init {
        api = createApi()
    }

    private fun createApi(): PokemonApi {
        return buildRetrofit().create(PokemonApi::class.java)
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.FEED_BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(buildGSON()))
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    private fun buildGSON(): Gson {
        return GsonBuilder().setLenient().create()
    }

    suspend fun getPokemonCards(): Feed? {
        return api.getPokemonCards()
    }
}