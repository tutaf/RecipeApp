package com.tutaf.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tutaf.recipeapp.ui.theme.RecipeAppTheme
import com.tutaf.recipeapp.view.CategoryScreen
import com.tutaf.recipeapp.view.HomeScreen
import com.tutaf.recipeapp.view.RecipeScreen
import com.tutaf.recipeapp.view.SearchScreen
import com.tutaf.recipeapp.view.categoryScreenRouteDefinition
import com.tutaf.recipeapp.view.homeScreenRouteDefinition
import com.tutaf.recipeapp.view.recipeScreenArgRecipeId
import com.tutaf.recipeapp.view.recipeScreenRoute
import com.tutaf.recipeapp.view.recipeScreenRouteDefinition
import com.tutaf.recipeapp.view.searchScreenRouteDefinition

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = homeScreenRouteDefinition,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background),

                    ) {
                    composable(homeScreenRouteDefinition) {
                        HomeScreen(
                            onMealClick = { meal ->
                                navController.navigate(recipeScreenRoute(meal.id))
                            }
                        )
                    }
                    composable(
                        recipeScreenRouteDefinition,
                        arguments = listOf(
                            navArgument(recipeScreenArgRecipeId) { type = NavType.LongType }
                        )
                    ) {
                        RecipeScreen { navController.navigateUp() }
                    }
                    composable(categoryScreenRouteDefinition){
                        CategoryScreen()
                    }
                    composable(searchScreenRouteDefinition){
                        SearchScreen()
                    }
                }
            }
        }
    }
}