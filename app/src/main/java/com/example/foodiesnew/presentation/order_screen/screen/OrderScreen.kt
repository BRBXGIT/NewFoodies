package com.example.foodiesnew.presentation.order_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.foodiesnew.presentation.order_screen.sections.CategoriesSection
import com.example.foodiesnew.presentation.order_screen.sections.MealCategoriesSection
import com.example.foodiesnew.presentation.order_screen.sections.MealsSection
import com.example.foodiesnew.presentation.order_screen.sections.OrderPlaceSection
import com.example.foodiesnew.presentation.order_screen.sections.RepeatLastOrderSection
import com.example.foodiesnew.ui.theme.mColors

@Composable
fun OrderScreen(
    mainScaffoldPadding: PaddingValues,
    orderScreenVM: OrderScreenVM
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
            .padding(mainScaffoldPadding),
        verticalArrangement = Arrangement.spacedBy(24.dp)

    ) {
        Spacer(modifier = Modifier.height(0.dp))

        OrderPlaceSection()

        CategoriesSection()

        RepeatLastOrderSection()

        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            val mealCategories by orderScreenVM.mealCategories.collectAsStateWithLifecycle()
            MealCategoriesSection(
                mealCategories = mealCategories,
                orderScreenVM = orderScreenVM
            )

            val chosenCategory = orderScreenVM.chosenCategory
            val meals by orderScreenVM.meals.collectAsStateWithLifecycle()
            val mealsSortedByCategory = meals.filter {
                it.strCategory == chosenCategory
            }
            MealsSection(meals = meals)
        }
    }
}