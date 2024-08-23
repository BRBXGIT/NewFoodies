package com.example.foodiesnew.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.foodiesnew.presentation.main_screen.navigation.MainScreenRoute
import com.example.foodiesnew.presentation.main_screen.navigation.mainScreen
import com.example.foodiesnew.presentation.order_screen.navigation.orderScreen
import com.example.foodiesnew.presentation.settings_screen.navigation.settingsScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { mainScaffoldPadding ->
        NavHost(
            navController = navController,
            startDestination = MainScreenRoute
        ) {
            mainScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )

            orderScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )

            settingsScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )
        }
    }
}