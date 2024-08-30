package com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.R
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun AddMealSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = mColors.tertiary
        )

        Surface {
            Box(
                modifier = Modifier.padding(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .background(
                                color = mColors.tertiary,
                                shape = mShapes.extraSmall
                            )
                            .weight(0.3f)
                    ) {
                        var mealCount by rememberSaveable { mutableIntStateOf(1) }
                        IconButton(
                            onClick = { if(mealCount != 1) mealCount -= 1 }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_minus_filled),
                                contentDescription = null,
                                tint = if(mealCount == 1) mColors.secondary else mColors.onTertiary
                            )
                        }

                        Text(
                            text = mealCount.toString(),
                            style = mTypography.bodyLarge
                        )

                        IconButton(
                            onClick = { if(mealCount != 99) mealCount += 1 }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_plus_filled),
                                contentDescription = null,
                                tint = if(mealCount == 99) mColors.secondary else mColors.onTertiary
                            )
                        }
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.weight(0.7f),
                        shape = mShapes.extraSmall
                    ) {
                        Text(
                            text = "Add for 110$",
                            style = mTypography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}