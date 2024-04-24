package com.tutaf.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tutaf.recipeapp.ui.theme.RecipeAppTheme
import com.tutaf.recipeapp.view.CategoryScreen
import com.tutaf.recipeapp.view.categoryScreenRouteDefinition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = categoryScreenRouteDefinition,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background),

                    ) {
//                    composable(homeScreenRouteDefinition) {
//                        HomeScreen(
//                            onMealClick = { meal ->
//                                navController.navigate(recipeScreenRoute(meal.id))
//                            }
//                        )
//                    }
//                    composable(
//                        recipeScreenRouteDefinition,
//                        arguments = listOf(
//                            navArgument(recipeScreenArgRecipeId) { type = NavType.LongType }
//                        )
//                    ) {
//                        RecipeScreen { navController.navigateUp() }
//                    }
                    composable(categoryScreenRouteDefinition){
                        CategoryScreen()
                    }
//                    composable(searchScreenRouteDefinition){
//                        SearchScreen()
//                    }
                }
            }
        }
    }
}