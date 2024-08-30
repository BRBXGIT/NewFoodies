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

    @Query("DELETE FROM cartmeal WHERE title = :name")
    suspend fun deleteMealFromCartBy(name: String)

    @Query("UPDATE cartmeal SET amount = :amount WHERE title = :name")
    suspend fun updateAmountMealFromCartByName(name: String, amount: Int)

    @Query("SELECT * FROM cartmeal")
    fun getAllMealsFromCart(): Flow<List<CartMeal>>
}