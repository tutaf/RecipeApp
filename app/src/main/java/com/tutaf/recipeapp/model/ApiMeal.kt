package com.tutaf.recipeapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiMeal(
    @Json(name="idMeal") val id: Long,
    @Json(name="strMeal") val name: String,
    @Json(name="strMealThumb") val thumbnailLink: String,
)