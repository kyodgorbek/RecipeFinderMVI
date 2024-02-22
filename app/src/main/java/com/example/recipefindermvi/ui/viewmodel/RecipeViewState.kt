package com.example.recipefindermvi.ui.viewmodel

import com.example.recipefindermvi.data.model.Meal

sealed class RecipeViewState {
    object Loading : RecipeViewState()
    data class Success(val recipes: List<Meal>) : RecipeViewState()
    data class Error(val message: String) : RecipeViewState()
}