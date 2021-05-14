package com.moblab.cnn_news.test

import android.content.Context
import androidx.room.Room
import com.moblab.cnn_news.repository.database.AppDatabase
import com.moblab.cnn_news.repository.database.NewsDAO
import io.swagger.client.model.NewsDetails
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class DatabaseTest {

    private lateinit var db: AppDatabase
    private lateinit var dao: NewsDAO


    @Before
    @Throws(Exception::class)
    fun setUp() {
        val context = mock(Context::class.java)
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
        dao = db.newsDao()
    }

    @Test
    fun insertAndGetNewsTest() {

        val title = "wao"
        val newsDetails = NewsDetails()
        newsDetails.title = "Wao"
        lateinit var result : NewsDetails
        Thread{
            dao.insertNews(newsDetails)
            result = dao.getNewsById(title)

            assertEquals(result.title, "Wao")
        }

    }

    @Test
    fun updateNewsTest() {

        val oldtitle = "wao"
        val newTitle = "NewString"
        val newsDetails = NewsDetails()
        newsDetails.title = oldtitle
        lateinit var result : NewsDetails
        Thread {
            dao.insertNews(newsDetails)
            result = dao.getNewsById(oldtitle)
            assertEquals(result.title, "Wao")

            newsDetails.title = newTitle

            dao.updateNews(newsDetails)
            result = dao.getNewsById(newTitle)
            assertEquals(result.title, "NewString")
        }

    }

    @Test
    fun deleteAllNewsTest(){

        val title = "SomeString"
        val newsDetails = NewsDetails()
        newsDetails.title = title
        lateinit var result : NewsDetails
        Thread{
            dao.insertNews(newsDetails)
            dao.deleteAllNews()
            result = dao.getNewsById(title)

            assertEquals(result,null)
        }

    }

    @After
    fun tearDown() {
        db.close()
    }
}