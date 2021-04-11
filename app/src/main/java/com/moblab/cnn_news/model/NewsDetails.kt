package com.moblab.cnn_news.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsdetails")
data class NewsDetails(
    @PrimaryKey(autoGenerate = true) var newsDetailId : Long?
)