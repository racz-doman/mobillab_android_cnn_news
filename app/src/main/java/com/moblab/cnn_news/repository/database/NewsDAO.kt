package com.moblab.cnn_news.repository.database

import androidx.room.*
import io.swagger.client.model.NewsDetails

@Dao
interface NewsDAO {
    @Query("SELECT * FROM NewsDetails")
    fun getAllNews(): List<NewsDetails>

    @Query("SELECT * FROM NewsDetails WHERE title = :title")
    fun getNewsById(title : String): NewsDetails

    @Insert
    fun insertNews(newsDetails: NewsDetails) : Long

    @Query("DELETE FROM NewsDetails")
    fun deleteAllNews()

    @Update
    fun updateNews(newsDetails: NewsDetails)
}