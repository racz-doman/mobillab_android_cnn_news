package com.moblab.cnn_news.ui

import android.content.Context
import com.moblab.cnn_news.ui.about.AboutPresenter
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton
import com.moblab.cnn_news.ui.news.NewsPresenter as NewsPresenter

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    /*
    @Provides
    @Singleton
    fun newsDetailsPresenter() = NewsDetailsPresenter

     */
    /*
    @Provides
    @Singleton
    fun newsPresenter() = NewsPresenter
    */
    @Provides
    @Singleton
    fun aboutPresenter() = AboutPresenter

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(4)
}