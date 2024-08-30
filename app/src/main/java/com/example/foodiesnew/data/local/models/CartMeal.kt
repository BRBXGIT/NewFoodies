package com.example.foodiesnew.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartMeal(
    @PrimaryKey
    val title: String,
    val ingredients: String,
    val image: String,
    val amount: Int
)