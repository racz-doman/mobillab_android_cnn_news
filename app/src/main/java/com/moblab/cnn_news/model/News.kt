package com.moblab.cnn_news.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class News(
    @PrimaryKey(autoGenerate = true)
    var newsId : Long?,
    @ColumnInfo(name= "title")
    var title: String,
    @ColumnInfo(name= "author")
    var author: String
)