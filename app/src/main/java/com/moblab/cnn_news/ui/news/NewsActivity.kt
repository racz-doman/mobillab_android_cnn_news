package com.moblab.cnn_news.ui.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moblab.cnn_news.R
import com.moblab.cnn_news.injector
import com.moblab.cnn_news.model.News
import com.moblab.cnn_news.ui.news.adapter.NewsAdapter
import com.moblab.cnn_news.ui.newsdetails.NewsDetailsPresenter
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

class NewsActivity : AppCompatActivity(), NewsScreen {

    @Inject
    lateinit var newsPresenter: NewsPresenter

    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)
        setSupportActionBar(toolbar)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        NewsPresenter.attachScreen(this)
    }

    override fun onStop() {
        NewsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        NewsPresenter.queryNews(this)
    }

    private fun initRecyclerView() {
        TODO("Not yet implemented")
    }

    override fun showNews(newsList: List<News>) {
        TODO("Not yet implemented")
    }

}