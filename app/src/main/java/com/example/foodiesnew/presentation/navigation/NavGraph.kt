package com.example.foodiesnew.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.foodiesnew.presentation.cart_screen.navigation.cartScreen
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.presentation.common_bars.MainScreensBottomBar
import com.example.foodiesnew.presentation.order_screen.navigation.OrderScreenRoute
import com.example.foodiesnew.presentation.order_screen.navigation.orderScreen
import com.example.foodiesnew.presentation.settings_screen.navigation.settingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = { MainScreensBottomBar(navController = navController) },
        topBar = { CommonTopAppBar() }
    ) { mainScaffoldPadding ->
        NavHost(
            navController = navController,
            startDestination = OrderScreenRoute
        ) {
            orderScreen(
                mainScaffoldPadding = mainScaffoldPadding,
                topAppBarScrollBehavior = scrollBehavior
            )

            settingsScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )

            cartScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )
        }
    }
}