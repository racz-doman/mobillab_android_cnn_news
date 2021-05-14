package io.swagger.client.model

import com.google.gson.annotations.SerializedName

data class Response (
    @SerializedName("pagination")
    var pagination: Pagination? = null,
    @SerializedName("data")
    var data: List<NewsDetails>? = ArrayList()
)