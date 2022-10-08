package com.demirci.marvel.data.source.dto.characters


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class İtem(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?
)