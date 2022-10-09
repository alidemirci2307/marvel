package com.demirci.marvel.data.source.model.character_details


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Creators(
    @SerializedName("available")
    @Expose
    val available: Int?,
    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?,
    @SerializedName("items")
    @Expose
    val items: List<İtemX>?,
    @SerializedName("returned")
    @Expose
    val returned: Int?
)