package com.tutaf.recipeapp.model

import android.util.Log

interface DataSource {
    suspend fun getCategories(): ApiCategories
    suspend fun getMealsByCategoryName(categoryName: String): ApiMeals
}

class DataSourceImpl : DataSource {
    private val mealDbApi: TheMealDbApi = mealdbApi

    override suspend fun getCategories(): ApiCategories {
        val response = mealDbApi.getCategories()
        val responseBody = response.body()

        val categories = if (response.isSuccessful && responseBody != null) {
            responseBody
        } else {
            Log.e("tagtag", "getCategories is either unsuccessful or null")
            ApiCategories(emptyList())
        }

        return categories
    }

    override suspend fun getMealsByCategoryName(categoryName: String): ApiMeals {
        val response = mealDbApi.getMealsByCategoryName(categoryName = categoryName)
        val responseBody = response.body()

        val meals = if (response.isSuccessful && responseBody != null) {
            responseBody
        } else {
            Log.e("tagtag", "getMealsByCategoryName is either unsuccessful or null")
            ApiMeals(emptyList())
        }

        return meals
    }
}