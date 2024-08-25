package com.example.foodiesnew.presentation.main_screen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.R
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun BonusSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BonusSurface(
                text = "Get",
                description = "More bonus",
                icon = R.drawable.ic_double_arrow_up
            )

            BonusSurface(
                text = "Accumulate",
                description = "Bonuses for purchase",
                icon = R.drawable.ic_qr_code_outlined
            )
        }
    }
}

@Composable
fun RowScope.BonusSurface(
    text: String,
    description: String,
    icon: Int
) {
    Surface(
        modifier = Modifier.weight(0.5f),
        shadowElevation = 2.dp,
        shape = mShapes.small,
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = text,
                    style = mTypography.labelLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = description,
                    style = mTypography.labelMedium.copy(
                        color = mColors.secondary
                    )
                )
            }

            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.BottomEnd),
                tint = mColors.primary
            )
        }
    }
}