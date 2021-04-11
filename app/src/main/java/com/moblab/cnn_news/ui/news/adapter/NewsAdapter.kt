package com.moblab.cnn_news.ui.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moblab.cnn_news.R
import com.moblab.cnn_news.model.News

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    val context: Context
    var newsList = mutableListOf<News>()

    constructor(context: Context) {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class ViewHolder(newsView: View) : RecyclerView.ViewHolder(newsView) {

    }
}