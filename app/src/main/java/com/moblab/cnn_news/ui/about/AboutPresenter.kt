package com.moblab.cnn_news.ui.about

import com.moblab.cnn_news.ui.Presenter

object AboutPresenter : Presenter<AboutScreen?>() {
    override fun attachScreen(screen: AboutScreen?) {
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        super.detachScreen()
    }

    fun getAboutDetails() {
        screen?.showAboutDetails()
    }
}