package com.demirci.marvel.data.source.dto.characters


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Stories(
    @SerializedName("available")
    @Expose
    val available: Int?,
    @SerializedName("collectionURI")
    @Expose
    val collectionURI: String?,
    @SerializedName("items")
    @Expose
    val items: List<İtemXXX>?,
    @SerializedName("returned")
    @Expose
    val returned: Int?
)