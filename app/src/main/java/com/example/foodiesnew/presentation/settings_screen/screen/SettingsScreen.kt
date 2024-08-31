package com.example.foodiesnew.presentation.settings_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.presentation.common_bars.CommonTopAppBar
import com.example.foodiesnew.presentation.settings_screen.sections.LogoSection
import com.example.foodiesnew.presentation.settings_screen.sections.SocialNetworksSection
import com.example.foodiesnew.presentation.settings_screen.sections.VersionPrivacyPolicySection
import com.example.foodiesnew.ui.theme.mColors

@Composable
fun SettingsScreen(
    mainScaffoldPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
            .padding(mainScaffoldPadding),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        LogoSection()

        HorizontalDivider(
            thickness = 1.dp,
            color = mColors.tertiary
        )

        VersionPrivacyPolicySection()

        SocialNetworksSection()
    }
}