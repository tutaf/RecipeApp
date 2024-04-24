package com.tutaf.recipeapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tutaf.recipeapp.viewModel.CategoriesViewModel
import  androidx.lifecycle.viewmodel.compose.viewModel
import com.tutaf.recipeapp.model.ApiCategory
import org.koin.androidx.compose.koinViewModel

const val categoriesScreenRouteDefinition = "category"

 @Composable
 fun CategoryScreen(
     viewModel: CategoriesViewModel = koinViewModel()
 ) {
     val categories by viewModel.categories.collectAsStateWithLifecycle()
 //    val meals by viewModel.meals.collectAsStateWithLifecycle()

     CategoriesScreenContent(categories)

}

@Composable
fun CategoriesScreenContent(categories: List<ApiCategory>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ItemBackgroundColor) // Background for entire screen
    ) {
        CenterAlignedTopAppBar(
            title = { Text("Categories") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories, key = { it.name }) { category ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(20.dp) // Rounded corners with shadows
                        )
                        .background(
                            color = ItemBackgroundColor,
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(16.dp) // Padding inside the Text
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun CategoriesScreenPreview()  {
    val categories = listOf(
        ApiCategory(1, "soijfd", "Category 1", "aaa"),





        )

    CategoriesScreenContent(categories = categories)
}

