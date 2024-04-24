package com.tutaf.recipeapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCategory(
    @Json(name="idCategory") val id: Long,
    @Json(name="strCategory") val name: String,
    @Json(name="strCategoryDescription") val description: String,
    @Json(name="strCategoryThumb") val thumbnailLink: String,
)