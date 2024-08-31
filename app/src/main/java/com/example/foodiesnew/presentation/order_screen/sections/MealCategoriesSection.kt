package com.example.foodiesnew.presentation.order_screen.sections

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.foodiesnew.data.remote.models.Category
import com.example.foodiesnew.data.remote.models.Meal
import com.example.foodiesnew.presentation.order_screen.screen.OrderScreenVM
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mTypography
import kotlinx.coroutines.launch

@Composable
fun MealCategoriesSection(
    mealCategories: List<Category>,
    meals: List<Meal>,
    orderScreenVM: OrderScreenVM
) {
    if(mealCategories.isNotEmpty()) {
        val pagerState = rememberPagerState(pageCount = { mealCategories.size })
        var selectedCategory by rememberSaveable { mutableIntStateOf(0) }
        val animationScope = rememberCoroutineScope()

        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                selectedCategory = page
            }
        }

        ScrollableTabRow(
            selectedTabIndex = selectedCategory,
            edgePadding = 16.dp,
            divider = { HorizontalDivider(
                thickness = 1.dp,
                color = mColors.tertiary
            ) },
            indicator = { tabPositions ->
                if(selectedCategory < tabPositions.size) {
                    Box(
                        modifier = Modifier
                            .customTabIndicatorOffset(
                                currentTabPosition = tabPositions[selectedCategory],
                                width = 50.dp
                            )
                            .height(3.dp)
                            .background(
                                color = mColors.primary,
                                shape = RoundedCornerShape(topStart = 3.dp, topEnd = 3.dp)
                            )

                    )
                }
            }
        ) {
            mealCategories.forEachIndexed { index, category ->
                Tab(
                    selected = index == selectedCategory,
                    onClick = {
                        animationScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                        selectedCategory = index
                    },
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                    text = {
                        Text(
                            text = category.strCategory,
                            style = mTypography.bodyLarge.copy(
                                color = mColors.onBackground,
                                fontWeight = if(index == selectedCategory) FontWeight.Bold else FontWeight.Normal
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            val categoryByPage = mealCategories[page].strCategory
            val sortedMeals = meals.filter {
                it.strCategory == categoryByPage
            }

            MealsSection(
                meals = sortedMeals,
                orderScreenVM = orderScreenVM
            )
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
private fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    width: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = max(0.dp, currentTabWidth - width) / 2 + indicatorOffset)
        .width(width)
}



