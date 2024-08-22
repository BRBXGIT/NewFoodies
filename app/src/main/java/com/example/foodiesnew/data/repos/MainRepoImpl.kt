package com.example.foodiesnew.data.repos

import com.example.foodiesnew.data.models.MealList
import com.example.foodiesnew.data.network.MealApiInstance
import com.example.foodiesnew.domain.MainRepo
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val mealApiInstance: MealApiInstance
): MainRepo {

    override suspend fun getAllMeals(): MealList {
        return mealApiInstance.getAllMeals()
    }
}