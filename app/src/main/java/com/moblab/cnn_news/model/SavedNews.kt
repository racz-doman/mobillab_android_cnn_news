package com.moblab.cnn_news.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savednews")
data class SavedNews(
    @PrimaryKey(autoGenerate = true) var savedNewsId : Long?
)
