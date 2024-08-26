package com.example.foodiesnew.presentation.order_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.presentation.order_screen.sections.CategoriesSection
import com.example.foodiesnew.presentation.order_screen.sections.OrderPlaceSection
import com.example.foodiesnew.presentation.order_screen.sections.RepeatLastOrderSection
import com.example.foodiesnew.ui.theme.mColors

@Composable
fun OrderScreen(
    mainScaffoldPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
            .padding(mainScaffoldPadding)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)

    ) {
        Spacer(modifier = Modifier.height(0.dp))

        OrderPlaceSection()

        CategoriesSection()

        RepeatLastOrderSection()
    }
}