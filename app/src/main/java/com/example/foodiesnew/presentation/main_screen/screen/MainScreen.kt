package com.example.foodiesnew.presentation.main_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.presentation.main_screen.sections.BonusSection
import com.example.foodiesnew.presentation.main_screen.sections.GreetingSection
import com.example.foodiesnew.presentation.main_screen.sections.MobileOrderSection
import com.example.foodiesnew.presentation.main_screen.sections.PromotionsSection
import com.example.foodiesnew.ui.theme.mColors

@Composable
fun MainScreen(
    mainScaffoldPadding: PaddingValues
) {
    val mainColumnScrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
            .verticalScroll(mainColumnScrollState)
            .padding(mainScaffoldPadding),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        GreetingSection()

        BonusSection()

        PromotionsSection()

        MobileOrderSection()

        Spacer(modifier = Modifier.height(0.dp))
    }
}