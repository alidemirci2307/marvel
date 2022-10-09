package com.demirci.marvel.domain.model

import com.demirci.marvel.base.ListAdapterItem
import java.io.Serializable

data class CharacterModel(
    val id: Int?,
    val name: String?,
    val description: String?,
    val thumbnail: String?,
    val thumbnailExtension: String?,
    val comics: List<String?>,
    override val uniqueId: Long = 0
) : ListAdapterItem, Serializable
