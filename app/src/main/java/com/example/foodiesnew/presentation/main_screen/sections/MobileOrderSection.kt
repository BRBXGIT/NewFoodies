package com.example.foodiesnew.presentation.main_screen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun MobileOrderSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Mobile order",
            style = mTypography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                modifier = Modifier.weight(0.5f),
                shadowElevation = 1.dp,
                shape = mShapes.extraSmall
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Get in restaurant",
                        style = mTypography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.TopStart)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_city_outlined),
                        contentDescription = null,
                        tint = mColors.primary,
                        modifier = Modifier
                            .size(90.dp)
                            .padding(top = 24.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }

            Surface(
                modifier = Modifier.weight(0.5f),
                shadowElevation = 1.dp,
                shape = mShapes.extraSmall
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Order delivery",
                        style = mTypography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.TopStart)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_delivery_outlined),
                        contentDescription = null,
                        tint = mColors.primary,
                        modifier = Modifier
                            .size(90.dp)
                            .padding(top = 24.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
            }
        }
    }
}