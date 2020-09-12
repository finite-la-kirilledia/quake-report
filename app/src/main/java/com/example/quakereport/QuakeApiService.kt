package com.example.quakereport

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface QuakeApiService {

    @GET("query")
    fun getUsgsResponse(
        @Query("minmag") minmag: Int = 0,
        @Query("limit") limit: Int = 100,
        @Query("format") format: String = "geojson"
    ): Deferred<UsgsResponse>
}

object QuakeApi {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val service: QuakeApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://earthquake.usgs.gov/fdsnws/event/1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(QuakeApiService::class.java)
    }
}