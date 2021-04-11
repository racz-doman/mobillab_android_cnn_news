package com.moblab.cnn_news

import android.app.Application
import com.moblab.cnn_news.ui.UIModule

class CnnNewsApplication : Application() {
    lateinit var injector: CnnNewsApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerCnnNewsApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}