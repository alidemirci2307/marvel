package com.demirci.marvel.data.source.model.character_details


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Price(
    @SerializedName("price")
    @Expose
    val price: Int?,
    @SerializedName("type")
    @Expose
    val type: String?
)