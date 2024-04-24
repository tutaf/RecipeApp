package com.tutaf.recipeapp.model

import android.util.Log

interface DataSource {
    suspend fun getCategories(): ApiCategories
    suspend fun getMealsByCategoryName(categoryName: String): ApiMeals

    suspend fun getRecipeById(recipeId: String): ApiRecipe
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

    override suspend fun getRecipeById(recipeId: String): ApiRecipe {
        val response = mealDbApi.getRecipeById(recipeId = recipeId)
        val responseBody = response.body()

        val recipe: ApiRecipe = if (response.isSuccessful && responseBody != null) {
            transformRecipe(responseBody)
        } else {
            Log.e("tagtag", "getRecipeById is either unsuccessful or null")
            ApiRecipe("notfound", "", "", "", "", "", "", emptyList())
        }

        return recipe
    }

    private fun transformRecipe(recipe: Recipe): ApiRecipe {
        val recip: Recip = recipe.recip[0]
        return ApiRecipe(
            id = recip.id,
            name = recip.name,
            category = recip.category,
            area = recip.area,
            description = recip.description,
            thumbnailLink = recip.thumbnailLink,
            tags = recip.tags,
            ingredients = createIngredientList(recip)
        )
    }

    private fun createIngredientList(recipe: Recip): List<Ingredient> {
        val ingredients = mutableListOf<Ingredient>()
        for (i in 1..20) {
            val ingredientName = recipe.javaClass.getDeclaredField("ingredient$i").get(recipe) as String
            val measure = recipe.javaClass.getDeclaredField("measure$i").get(recipe) as String
            if (ingredientName.isNotEmpty()) {
                ingredients.add(Ingredient(ingredientName, measure))
            }
        }
        return ingredients
    }


}
