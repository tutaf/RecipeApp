package com.tutaf.recipeapp.view

import androidx.compose.foundation.layout.Arrangement
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
import org.koin.androidx.compose.koinViewModel


const val categoriesScreenRouteDefinition = "category"

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = koinViewModel(),
    onCategoryClick: (ApiCategory)->Unit

) {
    val categories by viewModel.categories.collectAsStateWithLifecycle()
//    val meals by viewModel.meals.collectAsStateWithLifecycle()

    CategoriesScreenContent(categories)

}

@Composable
fun CategoriesScreenContent(categories: List<ApiCategory>) {

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
