package com.tutaf.recipeapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class ApiCategories (
    @Json(name="categories") val categories: List<ApiCategory>
)