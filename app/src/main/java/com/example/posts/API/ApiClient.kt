package com.example.posts.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//creating a client that enables our application to interact with the Api
object ApiClient {
    val retrofit=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildApiClient(apiInterface:Class<T>):T{
        return retrofit.create(apiInterface)
    }
}