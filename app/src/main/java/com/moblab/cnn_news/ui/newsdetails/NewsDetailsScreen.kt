package com.moblab.cnn_news.ui.newsdetails

import com.moblab.cnn_news.model.NewsDetails

interface NewsDetailsScreen {
    fun showNewsDetails(newsData: NewsDetails)
    fun showError(errorMsg: String)
}