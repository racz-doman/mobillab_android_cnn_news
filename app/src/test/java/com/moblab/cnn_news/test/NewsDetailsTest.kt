package com.moblab.cnn_news.test

import android.content.Context
import androidx.room.Room
import com.moblab.cnn_news.interactor.news.NewsInteractor
import com.moblab.cnn_news.mock.MockNewsApi
import com.moblab.cnn_news.repository.database.AppDatabase
import com.moblab.cnn_news.repository.database.NewsDAO
import com.moblab.cnn_news.testInjector
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsPresenter
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsScreen
import com.moblab.cnn_news.utils.mock
import com.moblab.cnn_news.utils.nullableArgumentCaptor
import io.swagger.client.model.NewsDetails
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import java.util.concurrent.Executor
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class NewsDetailsTest {

    @InjectMocks
    lateinit var newsDetailsPresenter: NewsDetailsPresenter

    @Mock
    private lateinit var newsInteractor : NewsInteractor

    @Mock
    private lateinit var excutor : Executor

    @Mock
    private lateinit var newsDetailsScreen: NewsDetailsScreen

    private lateinit var contextMock : Context

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        MockitoAnnotations.initMocks(this)
        contextMock = RuntimeEnvironment.application.getApplicationContext()
        newsDetailsPresenter.attachScreen(newsDetailsScreen)
    }

    @Test
    fun getNewsByTitleTest(){
        val newsDetailsTitle = "Test"
        try {
            newsDetailsPresenter.queryNewsDetails("Test",contextMock)
        }catch (e : java.lang.Exception){
            //ignore database excpetion
        }
        verify(newsInteractor).getNewsById(newsDetailsTitle,contextMock)
    }


    @After
    fun tearDown() {
        newsDetailsPresenter.detachScreen()
    }
}