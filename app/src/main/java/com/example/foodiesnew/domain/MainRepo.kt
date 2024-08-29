package com.example.foodiesnew.domain

import com.example.foodiesnew.data.models.MealCategories
import com.example.foodiesnew.data.models.MealList

interface MainRepo {

    suspend fun getAllMeals(): MealList

    suspend fun getAllMealCategories(): MealCategories
}