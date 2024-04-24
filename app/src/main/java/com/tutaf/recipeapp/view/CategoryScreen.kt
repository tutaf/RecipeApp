package com.tutaf.recipeapp.view

import androidx.compose.runtime.Composable
import com.tutaf.recipeapp.model.ApiCategory


const val categoryScreenArgCategory = "category"
const val categoryScreenRouteDefinition = "category/{${categoryScreenArgCategory}}"
fun categoryScreenRoute(category: String) = "category/$category"

@Composable
fun CategoryScreen(
) {



}