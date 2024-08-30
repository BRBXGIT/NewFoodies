package com.example.foodiesnew.presentation.cart_screen.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.foodiesnew.R
import com.example.foodiesnew.data.local.models.CartMeal
import com.example.foodiesnew.presentation.cart_screen.screen.CartScreenVM
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun MealsFromCartSection(
    mealsFromCart: List<CartMeal>,
    cartScreenVM: CartScreenVM
) {
    LazyColumn {
        items(mealsFromCart, key = { it.title }) { cartMeal ->
            MealFromCartPreview(
                cartMeal = cartMeal,
                onMinusClick = {
                    if(cartMeal.amount == 1) {
                        cartScreenVM.deleteMealFromCart(cartMeal.title)
                    } else {
                        cartScreenVM.updateAmountMealFromCartByName(
                            name = cartMeal.title,
                            amount = cartMeal.amount - 1
                        )
                    }
                },
                onPlusClick = {
                    if(cartMeal.amount != 99) {
                        cartScreenVM.updateAmountMealFromCartByName(
                            name = cartMeal.title,
                            amount = cartMeal.amount + 1
                        )
                    }
                },
                modifier = Modifier.animateItem()
            )
        }
    }
}

@Composable
fun MealFromCartPreview(
    cartMeal: CartMeal,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp),
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .clip(mShapes.medium)
                    ) {
                        AsyncImage(
                            model = cartMeal.image,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = cartMeal.title,
                            style = mTypography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Text(
                            text = cartMeal.ingredients,
                            style = mTypography.bodyMedium,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .background(color = mColors.tertiary)
                                .clip(mShapes.extraSmall)
                                .clickable {
                                    onMinusClick()
                                },
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_minus_filled),
                                contentDescription = null
                            )
                        }

                        Text(
                            text = cartMeal.amount.toString(),
                            style = mTypography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .background(color = mColors.tertiary)
                                .clip(mShapes.extraSmall)
                                .clickable {
                                    onPlusClick()
                                },
                            contentAlignment = Alignment.Center,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_plus_filled),
                                contentDescription = null
                            )
                        }
                    }

                    Text(
                        text = "110$",
                        style = mTypography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = mColors.tertiary
        )
    }
}