package com.moblab.cnn_news.ui.newsdetails

import io.swagger.client.model.NewsDetails

interface NewsDetailsScreen {
    fun showNewsDetails(newsData: NewsDetails?)
    fun showError(errorMsg: String)
}