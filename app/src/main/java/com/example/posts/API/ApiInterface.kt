package com.example.posts.API

import com.example.posts.Models.Post
import retrofit2.Call
import retrofit2.http.GET
//This is where we put all our requests.
interface ApiInterface {
    @GET("posts")
    fun getPosts():Call<List<Post>>
}