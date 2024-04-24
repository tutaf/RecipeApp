package com.tutaf.recipeapp.model

interface Repository {
    suspend fun getCategories(): List<ApiCategory>
    suspend fun getMealsByCategoryName(categoryName: String): List<ApiMeal>
}

class RepositoryImpl(private val dataSource: DataSource): Repository {
    override suspend fun getCategories(): List<ApiCategory> {
        return dataSource.getCategories().categories
    }

    override suspend fun getMealsByCategoryName(categoryName: String): List<ApiMeal> {
        return dataSource.getMealsByCategoryName(categoryName).meals
    }

}