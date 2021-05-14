package io.swagger.client.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class NewsDetails (
    @PrimaryKey(autoGenerate = true)
    var newsId: Long? = null,
    @SerializedName("author")
    var author: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("source")
    var source: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("category")
    var category: String? = null,
    @SerializedName("language")
    var language: String? = null,
    @SerializedName("country")
    var country: String? = null

)