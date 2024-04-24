//package com.tutaf.recipeapp.view
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import com.tutaf.recipeapp.viewModel.RecipeViewModel
//import  androidx.lifecycle.viewmodel.compose.viewModel
//
//const val recipeScreenArgRecipeId = "recipeId"
//const val recipeScreenRouteDefinition = "recipes/{$recipeScreenArgRecipeId}"
//fun recipeScreenRoute(recipeId: Long) = "recipes/$recipeId"
//
//@Composable
//fun RecipeScreen(
//    onUpClick: () -> Boolean,
//    viewModel: RecipeViewModel = viewModel()
//) {
//
//    val recipe by viewModel.recipe.collectAsStateWithLifecycle()
//
//
//}
