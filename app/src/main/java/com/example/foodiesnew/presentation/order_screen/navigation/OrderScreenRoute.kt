package com.example.foodiesnew.presentation.order_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.foodiesnew.presentation.order_screen.screen.OrderScreen
import kotlinx.serialization.Serializable

@Serializable
object OrderScreenRoute

fun NavGraphBuilder.orderScreen(
    mainScaffoldPadding: PaddingValues
) = composable<OrderScreenRoute> {
    OrderScreen(mainScaffoldPadding = mainScaffoldPadding)
}