//package com.tutaf.recipeapp.viewModel
//
import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.tutaf.recipeapp.model.ApiMeal
import com.tutaf.recipeapp.model.Repository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//import kotlinx.coroutines.launch
//
class HomeViewModel (
    val repo: Repository
): ViewModel() {

//
//    private val _meal: MutableStateFlow<List<ApiMeal>> = MutableStateFlow(emptyList())
//    val meal: StateFlow<List<ApiMeal>> = _meal.asStateFlow()
//
//    init {
//        loadData()
//    }
//
//    private fun loadData() {
//        viewModelScope.launch {
//            val response = repo.getRandomRecipes()
//
//            _meal.update {
//                response
//            }
//        }
//    }
//
//
}