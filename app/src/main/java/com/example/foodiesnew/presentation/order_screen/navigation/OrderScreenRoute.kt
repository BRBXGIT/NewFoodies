package com.example.foodiesnew.presentation.order_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.foodiesnew.presentation.order_screen.screen.OrderScreen
import com.example.foodiesnew.presentation.order_screen.screen.OrderScreenVM
import kotlinx.serialization.Serializable

@Serializable
object OrderScreenRoute

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.orderScreen(
    mainScaffoldPadding: PaddingValues,
    topAppBarScrollBehavior: TopAppBarScrollBehavior
) = composable<OrderScreenRoute> {
    val orderScreenVM = hiltViewModel<OrderScreenVM>()
    OrderScreen(
        mainScaffoldPadding = mainScaffoldPadding,
        orderScreenVM = orderScreenVM,
        topAppBarScrollBehavior = topAppBarScrollBehavior
    )
}