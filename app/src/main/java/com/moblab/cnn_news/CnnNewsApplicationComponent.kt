package com.moblab.cnn_news

import com.moblab.cnn_news.interactor.InteractorModule
import com.moblab.cnn_news.repository.network.NetworkModule
import com.moblab.cnn_news.ui.UIModule
import com.moblab.cnn_news.ui.about.AboutActivity
import com.moblab.cnn_news.ui.news.NewsActivity
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsActivity
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsScreen
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface CnnNewsApplicationComponent {
    fun inject(newsActivity: NewsActivity)
    fun inject(newsDetailsActivity: NewsDetailsActivity)
}