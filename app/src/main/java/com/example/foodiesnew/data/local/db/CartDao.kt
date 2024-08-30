package com.example.foodiesnew.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.foodiesnew.data.local.models.CartMeal
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Upsert
    suspend fun upsertMealToCart(cartMeal: CartMeal)

    @Delete
    suspend fun deleteMealFromCart(cartMeal: CartMeal)

    @Update
    suspend fun updateMealFromCart(cartMeal: CartMeal)

    @Query("SELECT * FROM cartmeal")
    suspend fun getAllMealsFromCart(): Flow<List<CartMeal>>
}