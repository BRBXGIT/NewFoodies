package com.example.foodiesnew.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Dispatcher(FoodiesDispatchers.IO)
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(FoodiesDispatchers.Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}