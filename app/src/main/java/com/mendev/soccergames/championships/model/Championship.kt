package com.mendev.soccergames.championships.model

import com.google.gson.annotations.SerializedName

data class Championship(
    @SerializedName("campeonato_id") val id: Int,
    @SerializedName("nome") val name: String,
    @SerializedName("nome_popular") val popularName: String,
    val slug: String,
    val status: String
)