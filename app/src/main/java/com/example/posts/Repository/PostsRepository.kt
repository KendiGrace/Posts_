package com.example.posts.Repository

import com.example.posts.API.ApiClient
import com.example.posts.API.ApiInterface
import com.example.posts.Models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Call

class PostsRepository {
    val retrofit= ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun getPosts():Call<List<Post>> =
//        Dispatchers.IO assigns the task to a random thread that helps in executing the request
        withContext(Dispatchers.IO){
            var response=retrofit.getPosts()
            return@withContext response
        }




}