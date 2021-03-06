package com.moblab.cnn_news.ui.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moblab.cnn_news.R
import com.moblab.cnn_news.injector
import com.moblab.cnn_news.model.About
import javax.inject.Inject

class AboutActivity : AppCompatActivity(), AboutScreen {

    @Inject
    lateinit var aboutPresenter: AboutPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_details)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        AboutPresenter.attachScreen(this)
    }

    override fun onStop() {
        AboutPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        AboutPresenter.queryAboutDetails(this)
    }

    override fun showAboutDetails(newsData: About) {
        TODO("Not yet implemented")
    }
}