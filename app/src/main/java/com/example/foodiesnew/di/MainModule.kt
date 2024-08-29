package com.example.foodiesnew.di

import com.example.foodiesnew.data.network.MealApiInstance
import com.example.foodiesnew.data.repos.MainRepoImpl
import com.example.foodiesnew.domain.MainRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideMainApiInstance(): MealApiInstance {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMainRepo(mealApiInstance: MealApiInstance): MainRepo {
        return MainRepoImpl(mealApiInstance)
    }
}