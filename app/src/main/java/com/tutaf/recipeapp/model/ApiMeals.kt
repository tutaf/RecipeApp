package com.tutaf.recipeapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class ApiMeals (
    @Json(name="meals") val meals: List<ApiMeal>
)