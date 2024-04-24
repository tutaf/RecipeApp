package com.tutaf.recipeapp.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tutaf.recipeapp.viewModel.CategoriesViewModel
import  androidx.lifecycle.viewmodel.compose.viewModel



const val categoryScreenArgCategory = "category"
const val categoryScreenRouteDefinition = "category/{${categoryScreenArgCategory}}"
fun categoryScreenRoute(category: String) = "category/$category"

@Composable
fun CategoryScreen(
    viewModel: CategoriesViewModel = viewModel()
) {
    val category by viewModel.categories.collectAsStateWithLifecycle()

}