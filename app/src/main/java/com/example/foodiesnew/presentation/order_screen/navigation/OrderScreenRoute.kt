package com.example.foodiesnew.presentation.order_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.foodiesnew.presentation.order_screen.screen.OrderScreen
import com.example.foodiesnew.presentation.order_screen.screen.OrderScreenVM
import kotlinx.serialization.Serializable

@Serializable
object OrderScreenRoute

fun NavGraphBuilder.orderScreen(
    mainScaffoldPadding: PaddingValues
) = composable<OrderScreenRoute> {
    val orderScreenVM = hiltViewModel<OrderScreenVM>()
    OrderScreen(
        mainScaffoldPadding = mainScaffoldPadding,
        orderScreenVM = orderScreenVM
    )
}