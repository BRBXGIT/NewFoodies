package com.example.foodiesnew.presentation.order_screen.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodiesnew.data.repos.MainRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class OrderScreenVM @Inject constructor(
    private val mainRepoImpl: MainRepoImpl
): ViewModel() {

    val mealCategories = flow {
        emit(mainRepoImpl.getAllMealCategories().categories)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        emptyList()
    )

    val meals = flow {
        emit(mainRepoImpl.getAllMeals().meals)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        emptyList()
    )

    private var _chosenCategory = MutableStateFlow("Beef")
    val chosenCategory = _chosenCategory.value

    fun setCategory(category: String) {
        _chosenCategory.value = category
    }
}