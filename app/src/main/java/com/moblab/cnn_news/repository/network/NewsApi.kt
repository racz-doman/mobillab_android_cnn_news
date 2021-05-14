package io.swagger.client.api

import io.swagger.client.model.NewsDetails
import io.swagger.client.model.Response
import retrofit2.Call
import retrofit2.http.*

interface NewsApi {

    @GET("news")
    fun getAllNews(
        @Query("access_key") accessKey: String,
        @Query("sources") sources: String,
        @Query("countries") countries: String,
        @Query("languages") languages: String,
        @Query("limit") limit: Int): Call<Response>

    @PUT("news")
    fun updateNews(
        @Body body: NewsDetails
    ): Call<Void?>?

    @POST("news")
    fun postNews(
        @Body body: NewsDetails): Call<Void?>?

    @GET("news/{title}")
    fun getNewsById(
        @Path("title") title: String): Call<NewsDetails>

    @DELETE("news/{id}")
    fun deleteNews(
        @Path("id") id: Long): Call<Void?>?
}