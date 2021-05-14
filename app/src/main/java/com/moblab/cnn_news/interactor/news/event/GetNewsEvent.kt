package com.moblab.cnn_news.interactor.news.event

import io.swagger.client.model.NewsDetails

data class GetNewsEvent (
    var code: Int = 0,
    var response: List<NewsDetails>? = null,
    var throwable: Throwable? = null
)