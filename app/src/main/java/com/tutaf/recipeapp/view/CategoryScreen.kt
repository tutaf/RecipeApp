package com.tutaf.recipeapp.view

import androidx.compose.runtime.Composable


const val categoryScreenArgCategory = "category"
const val categoryScreenRouteDefinition = "category/{${categoryScreenArgCategory}}"
fun categoryScreenRoute(category: String) = "category/$category"

@Composable
fun CategoryScreen(
) {



}