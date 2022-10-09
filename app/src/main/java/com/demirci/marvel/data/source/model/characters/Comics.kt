package com.demirci.marvel.data.source.model.characters


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Comics(
    @SerializedName("available")
    @Expose
    val available: Int,
    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String,
    @SerializedName("items")
    @Expose
    val items: List<Item>,
    @SerializedName("returned")
    @Expose
    val returned: Int
)