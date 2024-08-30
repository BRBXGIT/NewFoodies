package com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.data.models.Meal
import com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sections.AddMealSection
import com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sections.DescriptionSection
import com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sections.HeaderSection
import com.example.foodiesnew.ui.theme.mShapes
import kotlin.reflect.full.memberProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealBottomSheet(
    meal: Meal,
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        tonalElevation = 0.dp,
        shape = mShapes.extraSmall,
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

            AddMealSection()
        }
    }
}