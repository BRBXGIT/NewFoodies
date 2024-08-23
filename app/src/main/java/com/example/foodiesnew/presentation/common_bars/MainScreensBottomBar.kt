package com.example.foodiesnew.presentation.common_bars

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import com.example.foodiesnew.R
import com.example.foodiesnew.presentation.main_screen.navigation.MainScreenRoute
import com.example.foodiesnew.presentation.order_screen.navigation.OrderScreenRoute
import com.example.foodiesnew.presentation.settings_screen.navigation.SettingsScreenRoute

data class NavItem(
    val title: String,
    val icon: Int,
    val iconChosen: Int,
    val route: Any,
    val destination: String
)

@Composable
fun MainScreensBottomBar() {
    val navItems = listOf(
        NavItem(
            title = "Main",
            icon = R.drawable.ic_home_outlined,
            iconChosen = R.drawable.ic_home_filled,
            route = MainScreenRoute,
            destination = "MainScreenRoute"
        ),
        NavItem(
            title = "Order",
            icon = R.drawable.ic_ladle_outlined,
            iconChosen = R.drawable.ic_ladle_filled,
            route = OrderScreenRoute,
            destination = "OrderScreenRoute"
        ),
        NavItem(
            title = "Settings",
            icon = R.drawable.ic_settings_outlined,
            iconChosen = R.drawable.ic_settings_filled,
            route = SettingsScreenRoute,
            destination = "SettingsScreenRoute"
        )
    )
}