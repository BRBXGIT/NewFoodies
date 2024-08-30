package com.example.foodiesnew.presentation.order_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.room.util.foreignKeyCheck
import com.example.foodiesnew.presentation.order_screen.sections.CategoriesSection
import com.example.foodiesnew.presentation.order_screen.sections.ContainerWithScrollBehavior
import com.example.foodiesnew.presentation.order_screen.sections.MealCategoriesSection
import com.example.foodiesnew.presentation.order_screen.sections.OrderPlaceSection
import com.example.foodiesnew.presentation.order_screen.sections.RepeatLastOrderSection
import com.example.foodiesnew.ui.theme.mColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    mainScaffoldPadding: PaddingValues,
    orderScreenVM: OrderScreenVM,
    topAppBarScrollBehavior: TopAppBarScrollBehavior
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mColors.background)
            .padding(mainScaffoldPadding),
    ) {
        ContainerWithScrollBehavior(
            scrollBehavior = topAppBarScrollBehavior
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Spacer(modifier = Modifier.height(0.dp))

                OrderPlaceSection()

                CategoriesSection()

                RepeatLastOrderSection()

                Spacer(modifier = Modifier.height(0.dp))
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {
            val mealCategories by orderScreenVM.mealCategories.collectAsStateWithLifecycle()
            val meals by orderScreenVM.meals.collectAsStateWithLifecycle()
            MealCategoriesSection(
                mealCategories = mealCategories,
                meals = meals,
                orderScreenVM = orderScreenVM
            )
        }
    }
}