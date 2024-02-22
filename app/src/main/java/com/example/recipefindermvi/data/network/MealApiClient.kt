package com.example.recipefindermvi.data.network


import com.example.recipefindermvi.data.model.Meal
import com.example.recipefindermvi.data.model.MealResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealApiClient @Inject constructor(private val apiClient: HttpClient) {


    suspend fun getRandomRecipe(): List<Meal> {
        val url = "https://www.themealdb.com/api/json/v1/1/random.php"
        val response = apiClient.get(url).body() as MealResponse
        return response.meals
    }

    suspend fun getSearchedRecipe(query: String): List<Meal> {
        val url = "https://www.themealdb.com/api/json/v1/1/search.php?s=$query"
        val response = apiClient.get(url).body() as MealResponse
        return response.meals
    }
}

