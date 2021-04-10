package com.moblab.cnn_news.ui.news

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class NewsActivity : AppCompatActivity(), NewsScreen {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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
        //presenter függvénye lesz
    }

    // Az interface fuggvenye
    // Az inteface fuggvenye
}