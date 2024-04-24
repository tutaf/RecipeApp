package com.tutaf.recipeapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {


    private val _recipe: MutableStateFlow<ApiRecipe> = MutableStateFlow(emptyList())
    val recipe: StateFlow<ApiRecipe> = _recipe.asStateFlow()


    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val response = Something.getRecipeById()
            val responseBody = response.body()

            _recipe.update {
                if(response.isSuccessful && responseBody != null) {
                    responseBody
                } else {
                    emptyList()
                }
            }
        }
    }



}