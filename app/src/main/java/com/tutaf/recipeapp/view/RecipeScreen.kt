package com.tutaf.recipeapp.view

import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tutaf.recipeapp.viewModel.RecipeViewModel


const val recipeScreenArgRecipe = "recipes"
const val recipeScreenRouteDefinition = "recipes/{${recipeScreenArgRecipe}}"
fun recipeScreenRoute(category: String) = "recipes/$category"



@Composable
fun RecipeScreen(
    viewModel: RecipeViewModel = koinViewModel()
) {

    val recipe by viewModel.recipe.collectAsStateWithLifecycle()


}
