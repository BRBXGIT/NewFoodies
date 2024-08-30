package com.example.foodiesnew.presentation.order_screen.sections

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.foodiesnew.R
import com.example.foodiesnew.data.remote.models.Meal
import com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sheet.MealBottomSheet
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun MealsSection(
    meals: List<Meal>
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
            MealPreview(meal = meal)
        }
    }
}

@Composable
fun MealPreview(
    meal: Meal
) {
    var openMealBottomSheet by rememberSaveable { mutableStateOf(false) }
    if(openMealBottomSheet) {
        MealBottomSheet(
            meal = meal,
            onDismissRequest = { openMealBottomSheet = false }
        )
    }
    Surface(
        shadowElevation = 2.dp,
        shape = mShapes.extraSmall,
        modifier = Modifier.height(300.dp),
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
                AsyncImage(
                    model = "${meal.strMealThumb}/preview",
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
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