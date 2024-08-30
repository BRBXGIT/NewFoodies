package com.example.foodiesnew.presentation.cart_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.foodiesnew.presentation.cart_screen.screen.CartScreen
import com.example.foodiesnew.presentation.cart_screen.screen.CartScreenVM
import kotlinx.serialization.Serializable

@Serializable
object CartScreenRoute

fun NavGraphBuilder.cartScreen(
    mainScaffoldPadding: PaddingValues
) = composable<CartScreenRoute> {
    val cartScreenVM = hiltViewModel<CartScreenVM>()
    CartScreen(
        mainScaffoldPadding = mainScaffoldPadding,
        cartScreenVM = cartScreenVM
    )
}