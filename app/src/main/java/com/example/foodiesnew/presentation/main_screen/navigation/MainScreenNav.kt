package com.example.foodiesnew.presentation.main_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.foodiesnew.presentation.main_screen.screen.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object MainScreenRoute

fun NavGraphBuilder.mainScreen(
    mainScaffoldPadding: PaddingValues
) = composable<MainScreenRoute> {
    MainScreen(
        mainScaffoldPadding = mainScaffoldPadding
    )
}