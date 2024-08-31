package com.example.foodiesnew.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodiesnew.presentation.cart_screen.navigation.cartScreen
import com.example.foodiesnew.presentation.cart_screen.screen.CartScreenVM
import com.example.foodiesnew.presentation.cart_screen_fab.CartScreenFab
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.presentation.common_bars.MainScreensBottomBar
import com.example.foodiesnew.presentation.order_screen.navigation.OrderScreenRoute
import com.example.foodiesnew.presentation.order_screen.navigation.orderScreen
import com.example.foodiesnew.presentation.settings_screen.navigation.infoScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    
    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = if(currentDestination != null) currentDestination?.destination?.route.toString().split(".")[6] else "MainScreenRoute"
    
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val cartScreenVM = hiltViewModel<CartScreenVM>()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = { MainScreensBottomBar(
            navController = navController,
            cartScreenVM = cartScreenVM,
            currentRoute = currentRoute
        ) },
        topBar = { CommonTopAppBar() },
        floatingActionButton = {
            CartScreenFab(currentRoute = currentRoute)
        }
    ) { mainScaffoldPadding ->
        NavHost(
            navController = navController,
            startDestination = OrderScreenRoute
        ) {
            orderScreen(
                mainScaffoldPadding = mainScaffoldPadding,
                topAppBarScrollBehavior = scrollBehavior
            )

            infoScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )

            cartScreen(
                mainScaffoldPadding = mainScaffoldPadding,
                cartScreenVM = cartScreenVM
            )
        }
    }
}