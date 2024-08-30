package com.example.foodiesnew.presentation.cart_screen.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodiesnew.data.local.models.CartMeal
import com.example.foodiesnew.data.repos.MainRepoImpl
import com.example.foodiesnew.di.Dispatcher
import com.example.foodiesnew.di.FoodiesDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartScreenVM @Inject constructor(
    private val mainRepoImpl: MainRepoImpl,
    @Dispatcher(FoodiesDispatchers.IO) private val dispatcherIo: CoroutineDispatcher
): ViewModel() {
    fun updateAmountMealFromCartByName(name: String, amount: Int) {
        viewModelScope.launch(dispatcherIo) {
            mainRepoImpl.updateAmountMealFromCartByName(name, amount)
        }
    }

    fun deleteMealFromCart(name: String) {
        viewModelScope.launch(dispatcherIo) {
            mainRepoImpl.deleteMealFromCartBy(name)
        }
    }

    fun getMealsFromCart(): Flow<List<CartMeal>> {
        return mainRepoImpl.getAllMealsFromCart()
    }
}