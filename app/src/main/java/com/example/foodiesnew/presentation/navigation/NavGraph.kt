package com.example.foodiesnew.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodiesnew.R
import com.example.foodiesnew.presentation.cart_screen.navigation.cartScreen
import com.example.foodiesnew.presentation.cart_screen.screen.CartScreenVM
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.presentation.common_bars.MainScreensBottomBar
import com.example.foodiesnew.presentation.order_screen.navigation.OrderScreenRoute
import com.example.foodiesnew.presentation.order_screen.navigation.orderScreen
import com.example.foodiesnew.presentation.settings_screen.navigation.settingsScreen
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mTypography

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
            AnimatedVisibility(
                visible = currentRoute == "CartScreenRoute",
                enter = slideInVertically(tween(300)) + fadeIn(tween(300)),
                exit = slideOutVertically(tween(300)) + fadeOut(tween(300))
            ) {
                ExtendedFloatingActionButton(
                    containerColor = mColors.primary,
                    text = {
                        Text(
                            text = "Order",
                            style = mTypography.bodyLarge
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cart_outlined),
                            contentDescription = null
                        )
                    },
                    onClick = { /*TODO*/ }
                )
            }
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

            settingsScreen(
                mainScaffoldPadding = mainScaffoldPadding
            )

            cartScreen(
                mainScaffoldPadding = mainScaffoldPadding,
                cartScreenVM = cartScreenVM
            )
        }
    }
}