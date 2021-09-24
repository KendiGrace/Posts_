package com.example.posts.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.API.ApiClient
import com.example.posts.Models.Post
import com.example.posts.Models.PostRVAdapter
import com.example.posts.R
import com.example.posts.ViewModel.PostsViewModel
import com.example.posts.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
//implementing view binding that generates a binding class fir each xml file
    lateinit var binding:ActivityMainBinding
    lateinit var rvPosts:RecyclerView
    val postsViewModel:PostsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postsViewModel.postsLiveData.observe(this,{
          if (it!=null){
              val postsAdapter=PostRVAdapter(it as ArrayList<Post>,this)
              binding.rvPosts.layoutManager=LinearLayoutManager(baseContext)
              binding.rvPosts.adapter=postsAdapter


          }

        })
    }



}