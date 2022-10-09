package com.demirci.marvel.data.source.model.characters


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Item(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?
)