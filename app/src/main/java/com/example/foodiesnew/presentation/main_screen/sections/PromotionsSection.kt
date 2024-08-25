package com.example.foodiesnew.presentation.main_screen.sections

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.R
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
                )
            )

            TextButton(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Check all",
                    style = mTypography.bodyMedium.copy(
                        color = Color(0xff0278cd)
                    )
                )
            }
        }

        val promotionsTitleList = listOf(
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
            itemsIndexed(promotionsTitleList) { index, promotion ->
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

        val promotionsImageList = listOf(
            R.drawable.offer_3,
            R.drawable.offer_3,
            R.drawable.offer_3,
            R.drawable.offer_3
        )

        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(promotionsImageList) { promotionImage ->
                Box(
                    modifier = Modifier
                        .width(300.dp)
                        .height(200.dp)
                        .shadow(
                            elevation = 1.dp,
                            shape = mShapes.extraSmall
                        )
                        .clip(mShapes.extraSmall)
                ) {
                    Image(
                        painter = painterResource(id = promotionImage),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}