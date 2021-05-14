package com.moblab.cnn_news.ui.about

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.moblab.cnn_news.R
import com.moblab.cnn_news.injector
import kotlinx.android.synthetic.main.activity_about_details.*
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
        AboutPresenter.getAboutDetails()
    }

    override fun showAboutDetails() {
        tvName.text = "Rácz Domán Attila"
        tvNeptun.text = "IER825"
        tvVersion.text = "Version: 1.0.0"
    }
}