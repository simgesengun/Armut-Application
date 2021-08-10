package com.simgesengun.armutapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.armutapplication.databinding.CardBlogPostBinding
import com.simgesengun.armutapplication.entity.BlogPost

class BlogPostAdapter(var postList: List<BlogPost>, var blogPostOnClickListener: BlogPostOnClickListener) :
        RecyclerView.Adapter<BlogPostAdapter.CardBlogPostHolder>() {

    inner class CardBlogPostHolder(cardBlogPostBinding: CardBlogPostBinding) : RecyclerView.ViewHolder(cardBlogPostBinding.root){
        var binding : CardBlogPostBinding

        init {
            this.binding = cardBlogPostBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBlogPostHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val design = CardBlogPostBinding.inflate(layoutInflater, parent, false)

        return CardBlogPostHolder(design)
    }

    override fun onBindViewHolder(holder: CardBlogPostHolder, position: Int) {
        val blogPost = postList[position]
        holder.binding.blogPost = blogPost
        holder.binding.cardView.setOnClickListener { blogPostOnClickListener.toBlogPostDetails(blogPost) }

    }

    override fun getItemCount(): Int {
        return postList.size
    }


    interface BlogPostOnClickListener {
        fun toBlogPostDetails(blogPost : BlogPost)
    }
}