package com.moblab.cnn_news

import android.app.Activity

val Activity.injector: CnnNewsApplicationComponent
    get() {
        return (this.applicationContext as CnnNewsApplication).injector
    }

