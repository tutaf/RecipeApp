package com.tutaf.recipeapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutaf.recipeapp.model.ApiCategory
import com.tutaf.recipeapp.model.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CategoriesViewModel(
    private val repo : Repository ,

    ) : ViewModel() {

    private val _categories: MutableStateFlow<List<ApiCategory>> = MutableStateFlow(emptyList())
    val categories: StateFlow<List<ApiCategory>> = _categories.asStateFlow()


    init {
        getCategories()
    }


    private fun getCategories() {
        viewModelScope.launch {
            val response = repo.getCategories()
            _categories.update {
                response
            }
        }
    }




}