package com.moblab.cnn_news.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moblab.cnn_news.model.About
import com.moblab.cnn_news.model.News
import com.moblab.cnn_news.model.NewsDetails

@Database(entities = arrayOf(About::class, News::class, NewsDetails::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase::class.java, "news.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}