package com.example.foodiesnew.presentation.settings_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.ui.theme.mColors

@Composable
fun SettingsScreen(
    mainScaffoldPadding: PaddingValues
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CommonTopAppBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(mColors.background)
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = mainScaffoldPadding.calculateBottomPadding()
                )
        ) {

        }
    }
}