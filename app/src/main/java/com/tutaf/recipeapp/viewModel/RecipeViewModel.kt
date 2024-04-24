package com.tutaf.recipeapp.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutaf.recipeapp.model.ApiRecipe
import com.tutaf.recipeapp.model.Repository
import com.tutaf.recipeapp.view.recipeScreenArgRecipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeViewModel (
    private val repo: Repository,
    savedStateHandle: SavedStateHandle,
    ): ViewModel() {

    private val recipeId = requireNotNull(savedStateHandle.get<String>(recipeScreenArgRecipe))



    private val _recipe: MutableStateFlow<ApiRecipe> = MutableStateFlow(ApiRecipe("", "", "", "", "", "", "", emptyList()))
    val recipe: StateFlow<ApiRecipe> = _recipe.asStateFlow()


    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val response = repo.getRecipeById(recipeId)

            _recipe.update {
                response
            }
        }
    }



}