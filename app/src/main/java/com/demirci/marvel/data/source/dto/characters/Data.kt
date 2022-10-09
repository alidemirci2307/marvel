package com.demirci.marvel.data.source.dto.characters


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Data(
    @SerializedName("count")
    @Expose
    val count: Int?,
    @SerializedName("limit")
    @Expose
    val limit: Int?,
    @SerializedName("offset")
    @Expose
    val offset: Int?,
    @SerializedName("results")
    @Expose
    val results: List<Result>,
    @SerializedName("total")
    @Expose
    val total: Int?
)