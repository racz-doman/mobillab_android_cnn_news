package com.moblab.cnn_news.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "newsdetails")
data class NewsDetails(
    @PrimaryKey(autoGenerate = true)
    var newsDetailId : Long?,
    @ColumnInfo(name= "title")
    var title: String,
    @ColumnInfo(name= "author")
    var author: String,
    @ColumnInfo(name= "description")
    var description: String,
    @ColumnInfo(name= "link")
    var link: String,
    @ColumnInfo(name= "date")
    var date: String
)