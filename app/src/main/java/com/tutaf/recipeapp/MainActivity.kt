package com.tutaf.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import com.tutaf.recipeapp.ui.theme.RecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = postsScreenRouteDefinition,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background),

                    ) {
                    composable(postsScreenRouteDefinition) {
                        PostsScreen(
                            onPostClick = { post ->
                                navController.navigate(commentsScreenRoute(post.id))
                            }
                        )
                    }
                    composable(
                        commentsScreenRouteDefinition,
                        arguments = listOf(
                            navArgument(commentsScreenArgPostId) { type = NavType.LongType }
                        )
                    ) {
                        CommentsScreen(onUpClick = { navController.navigateUp() })
                    }
                }
            }
        }
    }
}