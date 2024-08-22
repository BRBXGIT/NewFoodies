package com.example.foodiesnew.presentation.common_bars

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.R
import com.example.foodiesnew.ui.theme.FullyWhite
import com.example.foodiesnew.ui.theme.PineGreen
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = PineGreen),
        title = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_foodies),
                    contentDescription = null
                )

                Text(
                    text = "Foodies",
                    style = mTypography.bodyMedium.copy(
                        color = FullyWhite
                    )
                )
            }
        }
    )
}