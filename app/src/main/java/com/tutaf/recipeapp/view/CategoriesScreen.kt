package com.tutaf.recipeapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tutaf.recipeapp.viewModel.CategoriesViewModel
import  androidx.lifecycle.viewmodel.compose.viewModel
import com.tutaf.recipeapp.model.ApiCategory


const val categoryScreenArgCategory = "category"
const val categoryScreenRouteDefinition = "category/{${categoryScreenArgCategory}}"
fun categoryScreenRoute(category: String) = "category/$category"

@Composable
fun CategoryScreen(
    viewModel: CategoriesViewModel = viewModel()
) {
    val categories by viewModel.categories.collectAsStateWithLifecycle()
    val meals by viewModel.meals.collectAsStateWithLifecycle()

    CategoryScreen(categories)

}

@Composable
fun CategoryScreen(categories: List<ApiCategory>) {

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(categories) { category ->
            Text(
                text = category.name,
            )
        }
    }
}
