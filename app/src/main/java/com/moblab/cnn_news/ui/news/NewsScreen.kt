package com.moblab.cnn_news.ui.news

import com.moblab.cnn_news.model.News

interface NewsScreen {
    fun showNews(newsList: List<News>)
}