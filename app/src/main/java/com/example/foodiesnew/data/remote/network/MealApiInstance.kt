package com.example.foodiesnew.data.remote.network

import com.example.foodiesnew.data.remote.models.MealCategories
import com.example.foodiesnew.data.remote.models.MealList
import retrofit2.http.GET

interface MealApiInstance {

    @GET("search.php?s")
    suspend fun getAllMeals(): MealList

    @GET("categories.php")
    suspend fun getAllMealCategories(): MealCategories
}