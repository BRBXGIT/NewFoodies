package com.example.foodiesnew.presentation.order_screen.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodiesnew.data.local.db.CartDao
import com.example.foodiesnew.data.local.models.CartMeal
import com.example.foodiesnew.data.repos.MainRepoImpl
import com.example.foodiesnew.di.Dispatcher
import com.example.foodiesnew.di.FoodiesDispatchers
import com.example.foodiesnew.presentation.common_bars.snackbars.SnackbarController
import com.example.foodiesnew.presentation.common_bars.snackbars.SnackbarEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderScreenVM @Inject constructor(
    private val mainRepoImpl: MainRepoImpl,
    private val cartDao: CartDao,
    @Dispatcher(FoodiesDispatchers.IO) private val dispatcherIo: CoroutineDispatcher,
): ViewModel() {

    val mealCategories = flow {
        try {
            emit(mainRepoImpl.getAllMealCategories().categories)
        } catch (e: Exception) {
            SnackbarController.sendEvent(
                event = SnackbarEvent(
                    message = "Something wrong with internet"
                )
            )
            emit(emptyList())
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        emptyList()
    )

    val meals = flow {
        try {
            emit(mainRepoImpl.getAllMeals().meals)
        } catch (e: Exception) {
            SnackbarController.sendEvent(
                event = SnackbarEvent(
                    message = e.message.toString()
                )
            )
            emit(emptyList())
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        emptyList()
    )

    fun upsertMealToCart(cartMeal: CartMeal) {
        viewModelScope.launch(dispatcherIo) {
            cartDao.upsertMealToCart(cartMeal)
        }
    }
}