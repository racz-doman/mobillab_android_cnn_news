package com.moblab.cnn_news.ui.newsdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moblab.cnn_news.R
import com.moblab.cnn_news.injector
import io.swagger.client.model.NewsDetails
import kotlinx.android.synthetic.main.activity_news_details.*
import kotlinx.android.synthetic.main.item_news.*
import javax.inject.Inject

class NewsDetailsActivity : AppCompatActivity(), NewsDetailsScreen {

    @Inject
    lateinit var newsDetailsPresenter: NewsDetailsPresenter

    private lateinit var newsTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        injector.inject(this)

        newsTitle = intent.getStringExtra("NEWS_TITLE")!!
        tvDtitle.text = newsTitle
    }

    override fun onStart() {
        super.onStart()
        newsDetailsPresenter.attachScreen(this)
    }

    override fun onStop() {
        newsDetailsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        newsDetailsPresenter.queryNewsDetails(newsTitle,this)
    }

    override fun showNewsDetails(newsData: NewsDetails?) {
        tvDauthor.text = if (newsData?.author == null) "Author: Unknown" else "Author: "+newsData.author
        tvDdescription.text = newsData?.description
        tvDcountry.text = "Country: "+newsData?.country
        tvDurl.text = newsData?.url
    }

    override fun showError(errorMsg: String) {
        tvTitle.text = errorMsg
    }

}