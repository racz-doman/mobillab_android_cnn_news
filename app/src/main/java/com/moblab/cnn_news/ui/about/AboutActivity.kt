package com.moblab.cnn_news.ui.about

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity(), AboutScreen {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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
        //presenter függvénye lesz
    }

    // Az interface fuggvenye
    // Az inteface fuggvenye
}