package com.demirci.marvel.data.source.model.character_details


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Thumbnail(
    @SerializedName("extension")
    @Expose
    val extension: String?,
    @SerializedName("path")
    @Expose
    val path: String?
)