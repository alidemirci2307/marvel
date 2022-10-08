package com.demirci.marvel.data.source.dto.characters


import com.demirci.marvel.domain.model.CharacterModel
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Result(
    @SerializedName("comics")
    @Expose
    val comics: Comics?,
    @SerializedName("description")
    @Expose
    val description: String?,
    @SerializedName("events")
    @Expose
    val events: Events?,
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("modified")
    @Expose
    val modified: String?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("resourceURI")
    @Expose
    val resourceURI: String?,
    @SerializedName("series")
    @Expose
    val series: Series?,
    @SerializedName("stories")
    @Expose
    val stories: Stories?,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: Thumbnail?,
    @SerializedName("urls")
    @Expose
    val urls: List<Url>?
) {
    fun toCharacter(): com.demirci.marvel.domain.model.CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            description = description,
            thumbnail = thumbnail?.path,
            thumbnailExtension = thumbnail?.extension,
            comics = comics?.items!!.map {
                it?.name
            }
        )
    }
}