package com.moblab.cnn_news.test

import android.content.Context
import com.moblab.cnn_news.interactor.news.NewsInteractor
import com.moblab.cnn_news.testInjector
import com.moblab.cnn_news.ui.news.NewsPresenter
import com.moblab.cnn_news.ui.news.NewsScreen
import com.moblab.cnn_news.utils.argumentCaptor
import com.moblab.cnn_news.utils.mock
import io.swagger.client.model.NewsDetails
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import javax.inject.Inject


@RunWith(RobolectricTestRunner::class)
class NewsTest {

    @Inject
    lateinit var newsPresenter: NewsPresenter

    private lateinit var newsScreen: NewsScreen

    private lateinit var newsInteractor : NewsInteractor

    private lateinit var context : Context

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        MockitoAnnotations.initMocks(this)
        newsScreen = mock()
        newsInteractor = mock()
        context = RuntimeEnvironment.application.getApplicationContext()
        newsPresenter.attachScreen(newsScreen)

    }

    @Test
    fun testNewsNotEmpty() {
        val list = argumentCaptor<MutableList<NewsDetails>>()
        try {
            newsPresenter.refreshNews(context)
        } catch (e : Exception){
            // Ignore Database Exception
        }
        verify(newsScreen).showNews(list.capture())
        assert(list.value.size > 0)
    }

    @Test
    fun getAllNewsTest(){
        val list = argumentCaptor<MutableList<NewsDetails>>()
        try {
            newsPresenter.refreshNews(context)
        } catch (e : java.lang.Exception){
            // Ignore Database Exception
        }
        verify(newsScreen).showNews(list.capture())
        verify(newsScreen, times(0)).showNetworkError(anyString())
        assert(list.value.get(0).title.equals("Wao those are the News") )
    }

    @After
    fun tearDown() {
        newsPresenter.detachScreen()
    }
}