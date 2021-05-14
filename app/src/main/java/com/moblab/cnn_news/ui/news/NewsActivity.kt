package com.moblab.cnn_news.ui.news

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.moblab.cnn_news.R
import com.moblab.cnn_news.injector
import com.moblab.cnn_news.interactor.news.NewsInteractor
import com.moblab.cnn_news.interactor.news.event.GetNewsEvent
import com.moblab.cnn_news.ui.about.AboutActivity
import com.moblab.cnn_news.ui.news.adapter.NewsAdapter
import com.moblab.cnn_news.ui.utils.hide
import com.moblab.cnn_news.ui.utils.show
import io.swagger.client.model.NewsDetails
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class NewsActivity : AppCompatActivity(), NewsScreen {

    @Inject
    lateinit var newsPresenter: NewsPresenter

    @Inject
    lateinit var newsInteractor: NewsInteractor

    lateinit var toggle: ActionBarDrawerToggle

    private var newsAdapter: NewsAdapter? = null

    private val displayedNews: MutableList<NewsDetails> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout , R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> drawerLayout.closeDrawer(GravityCompat.START)
                R.id.nav_about -> Intent(this,AboutActivity::class.java).also { startActivity(it) }
            }
            true
        }

        newsAdapter = NewsAdapter(this, displayedNews)
        rvNews.adapter = newsAdapter
        rvNews.layoutManager = LinearLayoutManager(this)

        newsPresenter.refreshNews(this)

        swipeRefreshLayoutNews.setOnRefreshListener {
            newsPresenter.refreshNews(this)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        newsPresenter.attachScreen(this)
    }

    override fun onStop() {
        newsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun showNetworkError(errorMsg: String) {
        swipeRefreshLayoutNews.isRefreshing = false
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }

    override fun showNews(newsList: List<NewsDetails>?) {
        swipeRefreshLayoutNews.isRefreshing = false
        displayedNews.clear()

        if (newsList != null) {
            displayedNews.addAll(newsList)
        }
        newsAdapter?.notifyDataSetChanged()

        if (displayedNews.isEmpty()) {
            rvNews.hide()
            tvEmpty.show()
        } else {
            rvNews.show()
            tvEmpty.hide()
        }
    }
}