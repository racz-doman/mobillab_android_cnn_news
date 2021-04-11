package com.moblab.cnn_news.ui

import android.content.Context
import com.moblab.cnn_news.ui.news.NewsPresenter
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun newsDetailsPresenter() = NewsDetailsPresenter

    @Provides
    @Singleton
    fun newsPresenter() = NewsPresenter

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(4)
}