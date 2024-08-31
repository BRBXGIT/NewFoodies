package com.example.foodiesnew.presentation.info_screen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.foodiesnew.presentation.info_screen.screen.InfoScreen
import kotlinx.serialization.Serializable

@Serializable
object InfoScreenRoute

fun NavGraphBuilder.infoScreen(
    mainScaffoldPadding: PaddingValues
) = composable<InfoScreenRoute> {
    InfoScreen(mainScaffoldPadding = mainScaffoldPadding)
}