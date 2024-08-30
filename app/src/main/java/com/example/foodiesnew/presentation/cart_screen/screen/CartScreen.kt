package com.example.foodiesnew.presentation.cart_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.foodiesnew.presentation.cart_screen.sections.MealsFromCartSection
import com.example.foodiesnew.ui.theme.mColors

@Composable
fun CartScreen(
    mainScaffoldPadding: PaddingValues,
    cartScreenVM: CartScreenVM
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
            .padding(mainScaffoldPadding)
    ) {
        val mealsFromCart by cartScreenVM.getMealsFromCart().collectAsStateWithLifecycle(
            initialValue = emptyList()
        )
        MealsFromCartSection(
            mealsFromCart = mealsFromCart,
            cartScreenVM = cartScreenVM
        )
    }
}