package com.moblab.cnn_news.interactor

import com.moblab.cnn_news.interactor.news.NewsInteractor
import dagger.Module
import dagger.Provides
import io.swagger.client.api.NewsApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideNewsInteractor(newsApi: NewsApi) = NewsInteractor(newsApi)
}