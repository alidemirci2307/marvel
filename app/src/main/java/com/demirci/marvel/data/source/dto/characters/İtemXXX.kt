package com.demirci.marvel.data.source.dto.characters


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class İtemXXX(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?,
    @SerializedName("type")
    @Expose
    val type: String?
)