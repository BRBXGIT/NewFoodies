package com.example.foodiesnew.presentation.main_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.presentation.main_screen.sections.BonusSection
import com.example.foodiesnew.presentation.main_screen.sections.GreetingSection
import com.example.foodiesnew.ui.theme.mColors

@Composable
fun MainScreen(
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
                    bottom = mainScaffoldPadding.calculateBottomPadding(),
                    top = innerPadding.calculateTopPadding()
                ),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            GreetingSection()

            BonusSection()
        }
    }
}