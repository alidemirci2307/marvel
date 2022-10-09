package com.demirci.marvel.data.source.model.character_details


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Date(
    @SerializedName("date")
    @Expose
    val date: String?,
    @SerializedName("type")
    @Expose
    val type: String?
)