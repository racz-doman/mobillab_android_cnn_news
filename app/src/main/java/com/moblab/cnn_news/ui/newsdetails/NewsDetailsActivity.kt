package com.moblab.cnn_news.ui.newsdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moblab.cnn_news.R
import com.moblab.cnn_news.injector
import com.moblab.cnn_news.model.NewsDetails
import com.moblab.cnn_news.ui.Presenter
import javax.inject.Inject

class NewsDetailsActivity : AppCompatActivity(), NewsDetailsScreen {

    @Inject
    lateinit var newsDetailsPresenter: NewsDetailsPresenter

    private lateinit var newsTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        injector.inject(this)
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        NewsDetailsPresenter.attachScreen(this)
    }

    override fun onStop() {
        NewsDetailsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        NewsDetailsPresenter.queryNewsDetails(newsTitle)
    }

    override fun showNewsDetails(newsData: NewsDetails) {
        TODO("Not yet implemented")
    }

    override fun showError(errorMsg: String) {
        TODO("Not yet implemented")
    }

}