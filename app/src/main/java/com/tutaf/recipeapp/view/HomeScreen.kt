package com.tutaf.recipeapp.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tutaf.recipeapp.viewModel.HomeViewModel
import  androidx.lifecycle.viewmodel.compose.viewModel

const val homeScreenRouteDefinition = "home"

@Composable
fun HomeScreen(
    onMealClick: (ApiMeal)-> Unit,
    viewModel: HomeViewModel = viewModel()
) {

    val meals by viewModel.meal.collectAsStateWithLifecycle()


}