package com.moblab.cnn_news.interactor.news

import android.util.Log
import android.content.Context
import com.moblab.cnn_news.interactor.news.event.GetNewsEvent
import com.moblab.cnn_news.interactor.news.event.GetSingleNewsEvent
import com.moblab.cnn_news.repository.database.AppDatabase
import com.moblab.cnn_news.repository.network.NetworkConfig
import io.swagger.client.api.NewsApi
import io.swagger.client.model.NewsDetails
import org.greenrobot.eventbus.EventBus
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject

open class NewsInteractor @Inject constructor(private var newsApi: NewsApi) {

    fun getAllNews(context: Context){
        val token = NetworkConfig.API_TOKEN
        val event = GetNewsEvent()

        //Checking internet connection
        if(isInternetWorking()) {
            try {
                val newsQueryCall = newsApi.getAllNews(token, "cnn", "us", "en", 10)

                val response = newsQueryCall.execute()
                Log.d("Response", response.body().toString())
                if (!response.isSuccessful) {
                    throw Exception("Result code is not successful")
                }
                event.code = response.code()
                event.response = response.body()?.data
                //EventBus.getDefault().post(event)

                // Saving to local as well
                Thread{
                    //Delete cache first
                    AppDatabase.getInstance(context).newsDao().deleteAllNews()

                    for(newsDetails : NewsDetails in response.body()?.data!!){
                        AppDatabase.getInstance(context).newsDao().insertNews(newsDetails)
                    }
                    event.response = AppDatabase.getInstance(context).newsDao().getAllNews()
                }.start()

                EventBus.getDefault().post(event)

            } catch (e: Exception) {
                event.throwable = e
                EventBus.getDefault().post(event)
            }
        }else{
            // Get data from cache if there is access to internet
            Thread{
                event.response = AppDatabase.getInstance(context).newsDao().getAllNews()
            }.start()
            EventBus.getDefault().post(event)
        }
    }

    //Doesn't support by mediastack api
    fun getNewsById(title : String, context : Context){
        val event = GetSingleNewsEvent()

        Thread{
            event.newsDetails = AppDatabase.getInstance(context).newsDao().getNewsById(title)
        }.start()

        EventBus.getDefault().post(event)
    }

    //Doesn't support by mediastack api
    fun updateNews(newsDetails: NewsDetails, context : Context){
        Thread {
            AppDatabase.getInstance(context).newsDao().updateNews(newsDetails)
        }.start()
    }
    //Doesn't support by mediastack api
    fun addNews(newsDetails: NewsDetails, context : Context){
        Thread {
            AppDatabase.getInstance(context).newsDao().insertNews(newsDetails)
        }.start()
    }
    //Doesn't support by mediastack api
    fun deleteNews(context : Context){
        Thread{
            AppDatabase.getInstance(context).newsDao().deleteAllNews()
        }.start()
    }

    fun isInternetWorking(): Boolean {
        var success = false
        try {
            val url = URL("https://google.com")
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.setConnectTimeout(10000)
            connection.connect()
            success = connection.getResponseCode() === 200
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return success
    }
}

