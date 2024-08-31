package com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.data.local.models.CartMeal
import com.example.foodiesnew.data.remote.models.Meal
import com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sections.AddMealSection
import com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sections.DescriptionSection
import com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sections.HeaderSection
import com.example.foodiesnew.presentation.order_screen.screen.OrderScreenVM
import com.example.foodiesnew.ui.theme.mShapes
import kotlin.reflect.full.memberProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealBottomSheet(
    meal: Meal,
    onDismissRequest: () -> Unit,
    orderScreenVM: OrderScreenVM
) {
    val state = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        tonalElevation = 0.dp,
        shape = mShapes.extraSmall,
        sheetState = state
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            HeaderSection(
                title = meal.strMeal,
                image = "${meal.strMealThumb}/preview"
            )

            var ingredients = ""
            for(ingredient in Meal::class.memberProperties) {
                if(ingredient.name.take(13) == "strIngredient") {
                    if((ingredient.get(meal) != "") && ingredient.get(meal) != "null") {
                        ingredients += if(ingredients.isNotEmpty()) {
                            "${ingredient.get(meal)}, ".lowercase()
                        } else {
                            "${ingredient.get(meal)}, "
                        }
                    }
                }
            }
            ingredients = ingredients.dropLast(2)

            DescriptionSection(ingredients = ingredients)

            var mealCount by rememberSaveable { mutableIntStateOf(1) }
            AddMealSection(
                mealCount = mealCount,
                onMinusClick = { mealCount -= 1 },
                onPlusClick = { mealCount += 1 },
                onAddMealClick = {
                    orderScreenVM.upsertMealToCart(CartMeal(
                        title = meal.strMeal,
                        ingredients = ingredients,
                        image = "${meal.strMealThumb}/preview",
                        amount = mealCount
                    ))
                    onDismissRequest()
                }
            )
        }
    }
}