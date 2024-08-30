package com.example.foodiesnew.data.repos

import com.example.foodiesnew.data.local.db.CartDao
import com.example.foodiesnew.data.local.models.CartMeal
import com.example.foodiesnew.data.remote.models.MealCategories
import com.example.foodiesnew.data.remote.models.MealList
import com.example.foodiesnew.data.remote.network.MealApiInstance
import com.example.foodiesnew.domain.MainRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val mealApiInstance: MealApiInstance,
    private val cartDao: CartDao
): MainRepo {

    override suspend fun getAllMeals(): MealList {
        return mealApiInstance.getAllMeals()
    }

    override suspend fun getAllMealCategories(): MealCategories {
        return mealApiInstance.getAllMealCategories()
    }

    override suspend fun upsertMealToCart(cartMeal: CartMeal) {
        cartDao.upsertMealToCart(cartMeal)
    }

    override suspend fun deleteMealFromCartBy(name: String) {
        cartDao.deleteMealFromCartBy(name)
    }

    override suspend fun updateAmountMealFromCartByName(name: String, amount: Int) {
        cartDao.updateAmountMealFromCartByName(name, amount)
    }

    override fun getAllMealsFromCart(): Flow<List<CartMeal>> {
        return cartDao.getAllMealsFromCart()
    }
}