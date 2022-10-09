package com.demirci.marvel.data.source.model.character_details


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class CharacterDetailsResponse(
    @SerializedName("attributionHTML")
    @Expose
    val attributionHTML: String?,
    @SerializedName("attributionText")
    @Expose
    val attributionText: String?,
    @SerializedName("code")
    @Expose
    val code: Int?,
    @SerializedName("copyright")
    @Expose
    val copyright: String?,
    @SerializedName("data")
    @Expose
    val `data`: Data?,
    @SerializedName("etag")
    @Expose
    val etag: String?,
    @SerializedName("status")
    @Expose
    val status: String?
)