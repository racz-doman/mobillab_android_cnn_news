package com.moblab.cnn_news.mock

import io.swagger.client.api.NewsApi
import io.swagger.client.model.NewsDetails
import io.swagger.client.model.Response
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import java.io.IOException

class MockNewsApi : NewsApi {
    override fun getAllNews(
        accessKey: String,
        sources: String,
        countries: String,
        languages: String,
        limit: Int
    ): Call<Response> {
        val response = Response()
        val newsDetails = NewsDetails()

        val news = ArrayList<NewsDetails>()

        newsDetails.author = "James"
        newsDetails.category = "Tennis"
        newsDetails.country = "United States"
        newsDetails.description = "Very high quality description"
        newsDetails.image = "http://img.com/niceimage.png"
        newsDetails.language = "english"
        newsDetails.newsId = 0
        newsDetails.title = "Wao those are the News"

        news.add(newsDetails)

        response.data = news

        val call = object : Call<Response> {
            @Throws(IOException::class)
            override fun execute(): retrofit2.Response<Response> {
                return retrofit2.Response.success(response)
            }

            override fun enqueue(callback: Callback<Response>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<Response> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun getNewsById(title: String): Call<NewsDetails> {
        val newsDetails = NewsDetails()

        newsDetails.author = "James"
        newsDetails.category = "Tennis"
        newsDetails.country = "United States"
        newsDetails.description = "Very high quality description"
        newsDetails.image = "http://img.com/niceimage.png"
        newsDetails.language = "english"
        newsDetails.newsId = 1L
        newsDetails.title = title
        newsDetails.url = "http://url.com"
        newsDetails.source = "cnn"

        val call = object : Call<NewsDetails> {
            @Throws(IOException::class)
            override fun execute(): retrofit2.Response<NewsDetails> {
                return retrofit2.Response.success(newsDetails)
            }

            override fun enqueue(callback: Callback<NewsDetails>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<NewsDetails> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun updateNews(body: NewsDetails): Call<Void?>? {
        TODO("Not yet implemented")
    }

    override fun postNews(body: NewsDetails): Call<Void?>? {
        TODO("Not yet implemented")
    }

    override fun deleteNews(id: Long): Call<Void?>? {
        TODO("Not yet implemented")
    }
}