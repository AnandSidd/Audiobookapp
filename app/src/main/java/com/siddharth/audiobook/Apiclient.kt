package com.siddharth.audiobook

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Apiclient {
    @GET("v3/2abb5b4e-b46b-4b0d-a7ba-a20eb394782a")
    suspend fun getdata() : Audio
}
val apiService: Apiclient by lazy {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    retrofit.create(Apiclient::class.java)
}