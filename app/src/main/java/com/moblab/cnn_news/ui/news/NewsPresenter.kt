package com.moblab.cnn_news.ui.news

import android.util.Log
import com.moblab.cnn_news.interactor.news.NewsInteractor
import com.moblab.cnn_news.interactor.news.event.GetNewsEvent
import com.moblab.cnn_news.ui.Presenter
import android.content.Context
import com.moblab.cnn_news.interactor.news.event.GetSingleNewsEvent
import io.swagger.client.model.NewsDetails
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class NewsPresenter  @Inject constructor(private val executor: Executor, private val newsInteractor: NewsInteractor) : Presenter<NewsScreen?>() {

    fun refreshNews(context: Context) {
        executor.execute {
            newsInteractor.getAllNews(context)
        }
    }
    override fun attachScreen(screen: NewsScreen?) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetNewsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.response != null) {
                    screen?.showNews(event.response as MutableList<NewsDetails>)
                }
            }
        }
    }

}