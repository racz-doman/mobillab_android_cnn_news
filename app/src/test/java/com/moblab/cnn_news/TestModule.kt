package com.moblab.cnn_news

import android.content.Context
import com.moblab.cnn_news.interactor.news.NewsInteractor
import com.moblab.cnn_news.ui.about.AboutPresenter
import com.moblab.cnn_news.ui.news.NewsActivity
import com.moblab.cnn_news.ui.news.NewsPresenter
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsPresenter
import com.moblab.cnn_news.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter() = NewsActivity()

    @Provides
    @Singleton
    fun provideNewsPresenter(executor: Executor, newsInteractor: NewsInteractor) = NewsPresenter(executor, newsInteractor)

    @Provides
    @Singleton
    fun provideAboutPresenter() = AboutPresenter

    @Provides
    @Singleton
    fun provideNewsDetailsPresenter(executor: Executor, newsInteractor: NewsInteractor) = NewsDetailsPresenter(executor, newsInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}