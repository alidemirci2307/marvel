package com.demirci.marvel.data.source.model.character_details


import com.demirci.marvel.domain.model.CharacterDetailsModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("characters")
    @Expose
    val characters: Characters?,
    @SerializedName("collectedIssues")
    @Expose
    val collectedIssues: List<Any>?,
    @SerializedName("collections")
    @Expose
    val collections: List<Any>?,
    @SerializedName("creators")
    @Expose
    val creators: Creators?,
    @SerializedName("dates")
    @Expose
    val dates: List<Date>?,
    @SerializedName("description")
    @Expose
    val description: String?,
    @SerializedName("diamondCode")
    @Expose
    val diamondCode: String?,
    @SerializedName("digitalId")
    @Expose
    val digitalId: Int?,
    @SerializedName("ean")
    @Expose
    val ean: String?,
    @SerializedName("events")
    @Expose
    val events: Events?,
    @SerializedName("format")
    @Expose
    val format: String?,
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("images")
    @Expose
    val images: List<Any>?,
    @SerializedName("isbn")
    @Expose
    val isbn: String?,
    @SerializedName("issn")
    @Expose
    val issn: String?,
    @SerializedName("issueNumber")
    @Expose
    val issueNumber: Int?,
    @SerializedName("modified")
    @Expose
    val modified: String?,
    @SerializedName("pageCount")
    @Expose
    val pageCount: Int?,
    @SerializedName("prices")
    @Expose
    val prices: List<Price>?,
    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?,
    @SerializedName("series")
    @Expose
    val series: Series?,
    @SerializedName("stories")
    @Expose
    val stories: Stories?,
    @SerializedName("textObjects")
    @Expose
    val textObjects: List<Any>?,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    @Expose
    val title: String?,
    @SerializedName("upc")
    @Expose
    val upc: String?,
    @SerializedName("urls")
    @Expose
    val urls: List<Url>?,
    @SerializedName("variantDescription")
    @Expose
    val variantDescription: String?,
    @SerializedName("variants")
    @Expose
    val variants: List<Any>?
) {
    fun toDomain(): CharacterDetailsModel {
        return CharacterDetailsModel(
            title = this.title
        )
    }
}