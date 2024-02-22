package com.example.recipefindermvi

import com.example.recipefindermvi.data.model.Meal
import com.example.recipefindermvi.data.network.MealApiClient
import com.example.recipefindermvi.ui.viewmodel.RecipeViewIntent
import com.example.recipefindermvi.ui.viewmodel.RecipeViewModel
import com.example.recipefindermvi.ui.viewmodel.RecipeViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class RecipeViewModelTest {

    // Mock dependencies
    @Mock
    lateinit var mealApiClient: MealApiClient

    // Class under test
    private lateinit var viewModel: RecipeViewModel

    // Set up main dispatcher for tests
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = RecipeViewModel(mealApiClient)
    }

    @Test
    fun `test loading random recipe`() = runBlockingTest {
        // Mock response
        val mockRecipe = meal
        `when`(mealApiClient.getRandomRecipe()).thenReturn(mockRecipe)

        // Trigger the method
        viewModel.processIntent(RecipeViewIntent.LoadingRandomRecipe)

        // Check if the state is Success and contains the expected recipe
        assertTrue(viewModel.state.value is RecipeViewState.Success)
        assertEquals(mockRecipe, (viewModel.state.value as RecipeViewState.Success).recipes)
    }

    @Test
    fun `test searching recipe`() = runBlockingTest {
        // Mock response
        val query = "Pasta"
        val mockRecipe = meal
        `when`(mealApiClient.getSearchedRecipe(query)).thenReturn(mockRecipe)

        // Trigger the method
        viewModel.processIntent(RecipeViewIntent.SearchRecipes(query))

        // Check if the state is Success and contains the expected recipe
        assertTrue(viewModel.state.value is RecipeViewState.Success)
        assertEquals(mockRecipe, (viewModel.state.value as RecipeViewState.Success).recipes)
    }

    @Test
    fun `test error loading random recipe`() = runBlockingTest {
        // Mock error
        `when`(mealApiClient.getRandomRecipe()).thenThrow(RuntimeException("Error fetching random recipe"))

        // Trigger the method
        viewModel.processIntent(RecipeViewIntent.LoadingRandomRecipe)

        // Check if the state is Error
        assertTrue(viewModel.state.value is RecipeViewState.Error)
    }

    @Test
    fun `test error searching recipe`() = runBlockingTest {
        // Mock error
        val query = "Pasta"
        `when`(mealApiClient.getSearchedRecipe(query)).thenThrow(RuntimeException("Error fetching recipe"))

        // Trigger the method
        viewModel.processIntent(RecipeViewIntent.SearchRecipes(query))

        // Check if the state is Error
        assertTrue(viewModel.state.value is RecipeViewState.Error)
    }

    companion object {
        val meal = listOf(
            Meal(
                dateModified = "2024-02-22",
                idMeal = "1",
                strArea = "Test Area",
                strCategory = "Test Category",
                strCreativeCommonsConfirmed = "Yes",
                strDrinkAlternate = "Alternate Drink",
                strImageSource = "Image Source",
                strIngredient1 = "Ingredient 1",
                strIngredient10 = "Ingredient 10",
                strIngredient11 = "Ingredient 11",
                strIngredient12 = "Ingredient 12",
                strIngredient13 = "Ingredient 13",
                strIngredient14 = "Ingredient 14",
                strIngredient15 = "Ingredient 15",
                strIngredient16 = "Ingredient 16",
                strIngredient17 = "Ingredient 17",
                strIngredient18 = "Ingredient 18",
                strIngredient19 = "Ingredient 19",
                strIngredient2 = "Ingredient 2",
                strIngredient20 = "Ingredient 20",
                strIngredient3 = "Ingredient 3",
                strIngredient4 = "Ingredient 4",
                strIngredient5 = "Ingredient 5",
                strIngredient6 = "Ingredient 6",
                strIngredient7 = "Ingredient 7",
                strIngredient8 = "Ingredient 8",
                strIngredient9 = "Ingredient 9",
                strInstructions = "Cook it well",
                strMeal = "Test Meal",
                strMealThumb = "Meal Thumbnail",
                strMeasure1 = "Measure 1",
                strMeasure10 = "Measure 10",
                strMeasure11 = "Measure 11",
                strMeasure12 = "Measure 12",
                strMeasure13 = "Measure 13",
                strMeasure14 = "Measure 14",
                strMeasure15 = "Measure 15",
                strMeasure16 = "Measure 16",
                strMeasure17 = "Measure 17",
                strMeasure18 = "Measure 18",
                strMeasure19 = "Measure 19",
                strMeasure2 = "Measure 2",
                strMeasure20 = "Measure 20",
                strMeasure3 = "Measure 3",
                strMeasure4 = "Measure 4",
                strMeasure5 = "Measure 5",
                strMeasure6 = "Measure 6",
                strMeasure7 = "Measure 7",
                strMeasure8 = "Measure 8",
                strMeasure9 = "Measure 9",
                strSource = "Source",
                strTags = "Tags",
                strYoutube = "Youtube Link"
            ),
            Meal(
                dateModified = "2024-02-22",
                idMeal = "1",
                strArea = "Test Area",
                strCategory = "Test Category",
                strCreativeCommonsConfirmed = "Yes",
                strDrinkAlternate = "Alternate Drink",
                strImageSource = "Image Source",
                strIngredient1 = "Ingredient 1",
                strIngredient10 = "Ingredient 10",
                strIngredient11 = "Ingredient 11",
                strIngredient12 = "Ingredient 12",
                strIngredient13 = "Ingredient 13",
                strIngredient14 = "Ingredient 14",
                strIngredient15 = "Ingredient 15",
                strIngredient16 = "Ingredient 16",
                strIngredient17 = "Ingredient 17",
                strIngredient18 = "Ingredient 18",
                strIngredient19 = "Ingredient 19",
                strIngredient2 = "Ingredient 2",
                strIngredient20 = "Ingredient 20",
                strIngredient3 = "Ingredient 3",
                strIngredient4 = "Ingredient 4",
                strIngredient5 = "Ingredient 5",
                strIngredient6 = "Ingredient 6",
                strIngredient7 = "Ingredient 7",
                strIngredient8 = "Ingredient 8",
                strIngredient9 = "Ingredient 9",
                strInstructions = "Cook it well",
                strMeal = "Test Meal",
                strMealThumb = "Meal Thumbnail",
                strMeasure1 = "Measure 1",
                strMeasure10 = "Measure 10",
                strMeasure11 = "Measure 11",
                strMeasure12 = "Measure 12",
                strMeasure13 = "Measure 13",
                strMeasure14 = "Measure 14",
                strMeasure15 = "Measure 15",
                strMeasure16 = "Measure 16",
                strMeasure17 = "Measure 17",
                strMeasure18 = "Measure 18",
                strMeasure19 = "Measure 19",
                strMeasure2 = "Measure 2",
                strMeasure20 = "Measure 20",
                strMeasure3 = "Measure 3",
                strMeasure4 = "Measure 4",
                strMeasure5 = "Measure 5",
                strMeasure6 = "Measure 6",
                strMeasure7 = "Measure 7",
                strMeasure8 = "Measure 8",
                strMeasure9 = "Measure 9",
                strSource = "Sources",
                strTags = "Tagsss",
                strYoutube = "Youtube Links"
            ),
        )


    }
}