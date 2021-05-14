package com.moblab.cnn_news.ui.newsdetails

import android.content.Context
import com.moblab.cnn_news.interactor.news.NewsInteractor
import com.moblab.cnn_news.interactor.news.event.GetNewsEvent
import com.moblab.cnn_news.interactor.news.event.GetSingleNewsEvent
import com.moblab.cnn_news.ui.Presenter
import io.swagger.client.model.NewsDetails
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class NewsDetailsPresenter @Inject constructor(private val executor: Executor, private val newsInteractor: NewsInteractor) : Presenter<NewsDetailsScreen?>(){
    fun queryNewsDetails(newsName: String, context: Context) {
        executor.execute {
            newsInteractor.getNewsById(newsName, context)
        }
    }

    override fun attachScreen(screen: NewsDetailsScreen?) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetSingleNewsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.newsDetails != null) {
                    screen?.showNewsDetails(event.newsDetails as NewsDetails)
                }
            }
        }
    }
}