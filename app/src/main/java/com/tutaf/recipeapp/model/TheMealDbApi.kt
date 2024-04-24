package com.tutaf.recipeapp.model


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

val mealdbApi = retrofit.create(TheMealDbApi::class.java)

interface TheMealDbApi {
    @GET("categories.php")
    suspend fun getCategories(): Response<ApiCategories>

    @GET("filter.php?c={categoryName}")
    suspend fun getMealsByCategoryName(
        @Query("categoryName") categoryName: String
    ): Response<ApiMeals>
}