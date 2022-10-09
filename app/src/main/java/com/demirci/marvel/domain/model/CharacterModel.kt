package com.demirci.marvel.domain.model

import com.demirci.marvel.base.ListAdapterItem
import java.io.Serializable

data class CharacterModel(
    val id: Int = 0,
    val name: String = "",
    val description: String= "",
    val thumbnail: String = "",
    val thumbnailExtension: String = "",
    val comics: List<String> = listOf(),
    val url: String = "${thumbnail.replace("http", "https")}/portrait_xlarge.$thumbnailExtension",
    override val uniqueId: Long = 0
) : ListAdapterItem, Serializable
