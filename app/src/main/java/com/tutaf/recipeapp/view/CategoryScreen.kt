package com.tutaf.recipeapp.view

import androidx.compose.runtime.Composable
import com.tutaf.recipeapp.model.ApiRecipe


const val categoryScreenArgCategory = "category"
const val categoryScreenRouteDefinition = "category/{${categoryScreenArgCategory}}"
fun categoryScreenRoute(category: String) = "category/$category"

@Composable
fun CategoryScreen(
    onRecipeClick: (ApiRecipe)->Unit
) {



}