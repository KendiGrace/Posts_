package com.example.posts.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
//implementing view binding that generates a binding class for each xml file
    lateinit var binding:ActivityMainBinding
    val postsViewModel:PostsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postsViewModel.fetchPosts()

        postsViewModel.postsLiveData.observe(this,{
          if (it!=null){
//              creating the adapter that takes in the list and displays them onthe recycler view.
              val postsAdapter=PostRVAdapter(it as ArrayList<Post>,this)
              binding.rvPosts.layoutManager=LinearLayoutManager(baseContext)
              binding.rvPosts.adapter=postsAdapter


          }
            else{
//                Showing an error after failure to fetch posts from the API.
                Toast.makeText(this,"An error occurred while fetching the posts",Toast.LENGTH_LONG).show()
          }

        })
    }



}