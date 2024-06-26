package com.tutaf.recipeapp.viewModel


import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutaf.recipeapp.model.ApiCategory
import com.tutaf.recipeapp.model.ApiMeal
import com.tutaf.recipeapp.model.Repository
import com.tutaf.recipeapp.view.categoryScreenArgCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CategoryViewModel(
    private val repo : Repository ,
    savedStateHandle: SavedStateHandle,

) : ViewModel() {

    private val category = requireNotNull(savedStateHandle.get<String>(categoryScreenArgCategory))


    private val _meals: MutableStateFlow<List<ApiMeal>> = MutableStateFlow(emptyList())
    private val _category: MutableStateFlow<ApiCategory> = MutableStateFlow(ApiCategory(
        name = "Loading...",
        id = 1,
        description = "Loading ...",
        thumbnailLink = "https://www.themealdb.com/images/media/meals/1550441275.jpg"

    ))
    val meals: StateFlow<List<ApiMeal>> = _meals.asStateFlow()
    val category_entity: StateFlow<ApiCategory> = _category.asStateFlow()


    init {
        getCategoryMeals()
    }

    private fun getCategoryMeals() {
        viewModelScope.launch {
            val response = repo.getMealsByCategoryName(category)

            _meals.update {
                response
            }
        }
    }

    private fun getCategory() {
        viewModelScope.launch {
            val response = repo.getCategories()

            for (item in response) {
                if (item.name == category) {
                    _category.update {
                        item
                    }
                }
            }
        }
    }

}