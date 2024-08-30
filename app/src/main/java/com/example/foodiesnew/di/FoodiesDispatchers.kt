package com.example.foodiesnew.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val foodiesDispatcher: FoodiesDispatchers)

enum class FoodiesDispatchers {
    Default,
    IO
}