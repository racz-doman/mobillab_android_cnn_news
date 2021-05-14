package com.moblab.cnn_news.interactor.news.event

import io.swagger.client.model.NewsDetails

data class GetSingleNewsEvent (
    var code: Int = 0,
    var newsDetails: NewsDetails? = null,
    var throwable: Throwable? = null
)
