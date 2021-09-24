package com.example.posts.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.Models.Post
import com.example.posts.Repository.PostsRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel: ViewModel() {
    var postsRepository = PostsRepository()
    var postsLiveData = MutableLiveData<List<Post>>()
    var postErrorLiveData = MutableLiveData<String>()

    fun fetchPosts(){
      viewModelScope.launch {
          val response=postsRepository.getPosts()
      response.enqueue(object :Callback<List<Post>> {
          override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
          if (response.isSuccessful){
              postsLiveData.postValue(response.body())
              Log.d("Response","${response.body()}")
          }
              else{

          }
          }

          override fun onFailure(call: Call<List<Post>>, t: Throwable) {

          }

      })

    }
}}