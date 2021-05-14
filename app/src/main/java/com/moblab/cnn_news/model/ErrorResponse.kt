package io.swagger.client.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse (
    @SerializedName("error")
    var error: Error? = null
)