package com.moblab.cnn_news.ui.newsdetails

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class NewsDetailsActivity : AppCompatActivity(), NewsDetailsScreen {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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
        //presenter függvénye lesz
    }

    // Az interface fuggvenye
    // Az inteface fuggvenye
}