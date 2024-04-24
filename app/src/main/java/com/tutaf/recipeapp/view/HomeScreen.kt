package com.tutaf.recipeapp.view


import HomeViewModel
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import  androidx.lifecycle.viewmodel.compose.viewModel
import com.tutaf.recipeapp.model.ApiMeal
import org.koin.androidx.compose.koinViewModel

const val homeScreenRouteDefinition = "home"

@Composable
fun HomeScreen(
    onMealClick: (ApiMeal)-> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {

//    val meals by viewModel.meal.collectAsStateWithLifecycle()


}
