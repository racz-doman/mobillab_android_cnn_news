package com.moblab.cnn_news.ui.news.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moblab.cnn_news.R
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsActivity
import io.swagger.client.model.NewsDetails
import kotlinx.android.synthetic.main.item_news.view.*

open class NewsAdapter (
        private val context: Context,
        var newsList: List<NewsDetails>
        ) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){


    inner class ViewHolder(newsView: View) : RecyclerView.ViewHolder(newsView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.apply {
            tvTitle.text = newsList[position].title
            tvAuthor.text = newsList[position].category
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra("NEWS_TITLE", newsList[position].title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}