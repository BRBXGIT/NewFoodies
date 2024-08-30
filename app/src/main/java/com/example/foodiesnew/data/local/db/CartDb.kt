package com.example.foodiesnew.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodiesnew.data.local.models.CartMeal

@Database(
    entities = [CartMeal::class],
    version = 1
)
abstract class CartDb: RoomDatabase() {

    abstract fun cartDao(): CartDao
}