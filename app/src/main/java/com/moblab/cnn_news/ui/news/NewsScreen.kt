package com.moblab.cnn_news.ui.news

import io.swagger.client.model.NewsDetails

interface NewsScreen {
    fun showNews(newsList: List<NewsDetails>?)
    fun showNetworkError(errorMsg: String)
}