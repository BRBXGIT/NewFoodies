package com.example.foodiesnew.domain

import com.example.foodiesnew.data.local.models.CartMeal
import com.example.foodiesnew.data.remote.models.MealCategories
import com.example.foodiesnew.data.remote.models.MealList
import kotlinx.coroutines.flow.Flow

interface MainRepo {

    suspend fun getAllMeals(): MealList

    suspend fun getAllMealCategories(): MealCategories

    suspend fun upsertMealToCart(cartMeal: CartMeal)

    suspend fun deleteMealFromCart(cartMeal: CartMeal)

    suspend fun updateMealFromCart(cartMeal: CartMeal)

    suspend fun getAllMealsFromCart(): Flow<List<CartMeal>>
}