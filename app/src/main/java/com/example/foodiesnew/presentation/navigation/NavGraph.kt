package com.example.foodiesnew.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.presentation.common_bars.MainScreensBottomBar
import com.example.foodiesnew.presentation.order_screen.navigation.OrderScreenRoute
import com.example.foodiesnew.presentation.order_screen.navigation.orderScreen
import com.example.foodiesnew.presentation.settings_screen.navigation.settingsScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { MainScreensBottomBar(navController = navController) },
        topBar = { CommonTopAppBar() }
    ) { mainScaffoldPadding ->
        NavHost(
            navController = navController,
            startDestination = OrderScreenRoute
        ) {
            orderScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )

            settingsScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )
        }
    }
}