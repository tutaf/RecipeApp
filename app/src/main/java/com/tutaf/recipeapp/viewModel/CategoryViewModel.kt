package com.tutaf.recipeapp.viewModel


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
    val meals: StateFlow<List<ApiMeal>> = _meals.asStateFlow()


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



}