package com.demirci.marvel.data.source.dto.characters


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Url(
    @SerializedName("type")
    @Expose
    val type: String?,
    @SerializedName("url")
    @Expose
    val url: String?
)