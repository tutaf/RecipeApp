package com.tutaf.recipeapp.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CategoriesViewModel(
    savedStateHandle: SavedStateHandle,

    ) : ViewModel() {

    private val category = requireNotNull(savedStateHandle.get<String>(commentsScreenArgCategory))


    private val _categories: MutableStateFlow<List<ApiCategory>> = MutableStateFlow(emptyList())
    val categories: StateFlow<List<ApiCategory>> = _categories.asStateFlow()

    private val _meal: MutableStateFlow<List<ApiMeal>> = MutableStateFlow(emptyList())
    val meal: StateFlow<List<ApiMeal>> = _meal.asStateFlow()



    init {
        getCategoryRecipes()
        getCategories()
    }

    private fun getCategoryRecipes() {
        viewModelScope.launch {
            val response = Something.getCategoryRecipes(category)
            val responseBody = response.body()

            _categories.update {
                if(response.isSuccessful && responseBody != null) {
                    responseBody
                } else {
                    emptyList()
                }
            }
        }
    }

    private fun getCategories() {
        viewModelScope.launch {
            val response = Something.getCategories()
            val responseBody = response.body()

            _categories.update {
                if(response.isSuccessful && responseBody != null) {
                    responseBody
                } else {
                    emptyList()
                }
            }
        }
    }




}