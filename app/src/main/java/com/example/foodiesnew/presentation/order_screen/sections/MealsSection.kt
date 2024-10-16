package com.example.foodiesnew.presentation.order_screen.sections

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.foodiesnew.R
import com.example.foodiesnew.data.remote.models.Meal
import com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sheet.MealBottomSheet
import com.example.foodiesnew.presentation.order_screen.screen.OrderScreenVM
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun MealsSection(
    meals: List<Meal>,
    orderScreenVM: OrderScreenVM
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 16.dp
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        items(meals) { meal ->
            MealPreview(
                meal = meal,
                orderScreenVM = orderScreenVM,
                modifier = Modifier.height(300.dp)
            )
        }
    }
}

@Composable
fun MealPreview(
    meal: Meal,
    orderScreenVM: OrderScreenVM,
    modifier: Modifier
) {
    var openMealBottomSheet by rememberSaveable { mutableStateOf(false) }
    if(openMealBottomSheet) {
        MealBottomSheet(
            meal = meal,
            onDismissRequest = { openMealBottomSheet = false },
            orderScreenVM = orderScreenVM
        )
    }
    Surface(
        shadowElevation = 2.dp,
        shape = mShapes.extraSmall,
        modifier = modifier,
        onClick = { openMealBottomSheet = true }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(mShapes.medium)
            ) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("${meal.strMealThumb}/preview")
                        .crossfade(500)
                        .size(Size.ORIGINAL)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    filterQuality = FilterQuality.Low,
                    contentScale = ContentScale.Crop,
                    loading = { AnimatedShimmer() }
                )
            }

            Text(
                text = meal.strMeal,
                style = mTypography.bodyLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "110$",
                    style = mTypography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .background(
                            color = mColors.primary,
                            shape = mShapes.extraSmall
                        )
                        .clickable { openMealBottomSheet = true }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus_filled),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun AnimatedShimmer() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )
    val transition = rememberInfiniteTransition(label = "transition")
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "translateAnim"
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    Box(
        modifier = Modifier
            .size(150.dp)
            .background(brush)
    )
}