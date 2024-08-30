package com.example.foodiesnew.di

import android.content.Context
import androidx.room.Room
import com.example.foodiesnew.data.local.db.CartDao
import com.example.foodiesnew.data.local.db.CartDb
import com.example.foodiesnew.data.remote.network.MealApiInstance
import com.example.foodiesnew.data.repos.MainRepoImpl
import com.example.foodiesnew.domain.MainRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideCartDao(
        @ApplicationContext context: Context
    ): CartDao {
        return Room.databaseBuilder(
            context = context,
            klass = CartDb::class.java,
            name = "CartDb"
        ).build().cartDao()
    }

    @Provides
    @Singleton
    fun provideMainRepo(
        mealApiInstance: MealApiInstance,
        cartDao: CartDao
    ): MainRepo {
        return MainRepoImpl(
            mealApiInstance = mealApiInstance,
            cartDao = cartDao
        )
    }
}