package com.moblab.cnn_news.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "about")
data class About(
    @PrimaryKey(autoGenerate = true)
    var aboutId : Long?,
    @ColumnInfo(name = "neptunkod")
    var neptunkod : String,
    @ColumnInfo(name = "fejleszto")
    var fejleszto : String
)