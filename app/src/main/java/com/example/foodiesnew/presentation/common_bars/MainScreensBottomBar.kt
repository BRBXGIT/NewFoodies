package com.example.foodiesnew.presentation.common_bars

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.foodiesnew.R
import com.example.foodiesnew.presentation.order_screen.navigation.OrderScreenRoute
import com.example.foodiesnew.presentation.settings_screen.navigation.SettingsScreenRoute
import com.example.foodiesnew.ui.theme.mTypography

data class NavItem(
    val title: String,
    val icon: Int,
    val iconChosen: Int,
    val route: Any,
    val destination: String
)

@Composable
fun MainScreensBottomBar(
    navController: NavHostController
) {
    val navItems = listOf(
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

    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = if(currentDestination != null) currentDestination?.destination?.route.toString().split(".")[6] else "MainScreenRoute"
    BottomAppBar(
        tonalElevation = 0.dp,
        modifier = Modifier.shadow(32.dp)
    ) {
        navItems.forEach { navItem ->
            NavigationBarItem(
                selected = navItem.destination == currentRoute,
                onClick = {
                    if(navItem.destination != currentRoute) {
                        navController.navigate(navItem.route)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = if(navItem.destination == currentRoute) navItem.iconChosen else navItem.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = navItem.title,
                        style = mTypography.labelLarge
                    )
                }
            )
        }
    }
}