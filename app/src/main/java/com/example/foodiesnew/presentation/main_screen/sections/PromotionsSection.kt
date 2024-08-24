package com.example.foodiesnew.presentation.main_screen.sections

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun PromotionsSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Promotions",
                style = mTypography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
            )

            Text(
                text = "Check all",
                style = mTypography.bodyMedium.copy(
                    color = Color(0xff0278cd)
                )
            )
        }

        val promotionsList = listOf(
            "Week offer",
            "Actual promotions",
            "Restaurant promotions",
            "More bonuses"
        )
        var chosenPromotionIndex by rememberSaveable { mutableIntStateOf(0) }

        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            itemsIndexed(promotionsList) { index, promotion ->
                val promotionBoxColor by animateColorAsState(
                    targetValue = if (index == chosenPromotionIndex) mColors.primary else mColors.tertiary,
                    label = "promotionBoxAnimatedColor"
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = promotionBoxColor,
                            shape = mShapes.extraSmall
                        )
                        .clickable {
                            chosenPromotionIndex = index
                        }
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = promotion,
                        style = mTypography.labelMedium
                    )
                }
            }
        }
    }
}