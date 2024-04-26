import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class Recipe(
    val name: String,
    val imageUrl: String,
    val ingredients: List<Ingredient>
)

data class Ingredient(
    val name: String,
    val measure: String
)

@Composable
fun RecipeScreen(recipe: Recipe) {
    RecipeScreenContent(recipe)
}

@Composable
fun RecipeScreenContent(recipe: Recipe) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Image at the top
        AsyncImage(
            model = recipe.imageUrl,
            contentDescription = "${recipe.name} image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Name of the recipe
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Ingredients header aligned to start
        Text(
            text = "Ingredients:",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Ingredients list
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(recipe.ingredients) { ingredient ->
                Text(
                    text = "- ${ingredient.name}: ${ingredient.measure}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeScreen() {
    val sampleRecipe = Recipe(
        name = "Chocolate Cake",
        imageUrl = "https://www.themealdb.com/images/category/dessert.png",
        ingredients = listOf(
            Ingredient("Flour", "2 Cups"),
            Ingredient("Sugar", "1 Cup"),
            Ingredient("Cocoa Powder", "3/4 Cup"),
            Ingredient("Baking Powder", "2 Teaspoons"),
            Ingredient("Eggs", "3 Large"),
            Ingredient("Milk", "1 Cup"),
            Ingredient("Butter", "1/2 Cup")
        )
    )
    RecipeScreen(sampleRecipe)
}
