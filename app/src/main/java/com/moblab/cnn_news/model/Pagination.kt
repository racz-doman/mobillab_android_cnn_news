package io.swagger.client.model

import com.google.gson.annotations.SerializedName

data class Pagination (
    @SerializedName("limit")
    var limit: Long? = null,
    @SerializedName("offset")
    var offset: Long? = null,
    @SerializedName("count")
    var count: Long? = null,
    @SerializedName("total")
    var total: Long? = null

)