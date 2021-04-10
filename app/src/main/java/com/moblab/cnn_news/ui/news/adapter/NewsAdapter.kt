package com.moblab.cnn_news.ui.news.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moblab.cnn_news.model.News

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    val context: Context
    var newsList = mutableListOf<News>()

    constructor(context: Context) {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(newsView: View) : RecyclerView.ViewHolder(newsView) {

    }
}