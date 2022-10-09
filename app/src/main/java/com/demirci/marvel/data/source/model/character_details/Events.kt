package com.demirci.marvel.data.source.model.character_details


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Events(
    @SerializedName("available")
    @Expose
    val available: Int?,
    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?,
    @SerializedName("items")
    @Expose
    val items: List<Any?>?,
    @SerializedName("returned")
    @Expose
    val returned: Int?
)