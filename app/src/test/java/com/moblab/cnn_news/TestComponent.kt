package com.moblab.cnn_news

import com.moblab.cnn_news.interactor.InteractorModule
import com.moblab.cnn_news.mock.MockNetworkModule
import com.moblab.cnn_news.test.AboutTest
import com.moblab.cnn_news.test.NewsDetailsTest
import com.moblab.cnn_news.test.NewsTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : CnnNewsApplicationComponent {
    fun inject(newsTest: NewsTest)
    fun inject(newsDetailsTest: NewsDetailsTest)
    fun inject(aboutTest: AboutTest)
}