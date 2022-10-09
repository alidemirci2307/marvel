package com.demirci.marvel.data.source.model.character_details


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Series(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?
)