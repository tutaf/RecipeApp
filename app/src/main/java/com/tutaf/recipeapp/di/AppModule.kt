package com.tutaf.recipeapp.di


import com.tutaf.recipeapp.model.DataSource
import com.tutaf.recipeapp.model.DataSourceImpl
import com.tutaf.recipeapp.model.Repository
import com.tutaf.recipeapp.model.RepositoryImpl
import com.tutaf.recipeapp.viewModel.CategoriesViewModel
//import com.tutaf.recipeapp.viewModel.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module{
    viewModelOf(::CategoriesViewModel)
//    viewModelOf(::RecipeViewModel)

    singleOf(::RepositoryImpl) bind Repository::class
    singleOf(::DataSourceImpl) bind DataSource::class

}