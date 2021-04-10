package com.moblab.cnn_news.ui.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moblab.cnn_news.R
import com.moblab.cnn_news.model.News
import com.moblab.cnn_news.ui.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.app_bar_main.*

class NewsActivity : AppCompatActivity(), NewsScreen {

    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)
        setSupportActionBar(toolbar)
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

    }

    override fun showNews(newsList: List<News>) {
        TODO("Not yet implemented")
    }

}