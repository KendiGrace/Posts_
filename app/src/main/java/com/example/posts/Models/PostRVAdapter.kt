package com.example.posts.Models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.posts.R

class PostRVAdapter(var postList:List<Post>,var context: Context) :RecyclerView.Adapter<PostRVAdapter.PostsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
       var itemView=LayoutInflater.from(parent.context).inflate(R.layout.postslist,parent,false)
        return PostsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
       var currentPost=postList.get(position)
        holder.userId.text=currentPost.userId.toString()
        holder.userId.text=currentPost.Id.toString()
        holder.title.text=currentPost.title
        holder.body.text=currentPost.body

    }

    override fun getItemCount(): Int {
      return postList.size
    }
    class PostsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var userId=itemView.findViewById<TextView>(R.id.tvUserId)
        var Id=itemView.findViewById<TextView>(R.id.tvId)
        var title=itemView.findViewById<TextView>(R.id.tvTitles)
        var body=itemView.findViewById<TextView>(R.id.tvBody)

    }
}
