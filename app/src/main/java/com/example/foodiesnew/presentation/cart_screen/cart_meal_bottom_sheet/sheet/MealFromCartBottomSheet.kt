package com.example.foodiesnew.presentation.cart_screen.cart_meal_bottom_sheet.sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.data.local.models.CartMeal
import com.example.foodiesnew.presentation.cart_screen.cart_meal_bottom_sheet.sections.CartDescriptionSection
import com.example.foodiesnew.presentation.cart_screen.cart_meal_bottom_sheet.sections.CartHeaderSection
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealFromCartBottomSheet(
    onDismissRequest: () -> Unit,
    cartMeal: CartMeal
) {
    val state = rememberModalBottomSheetState()
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
            CartHeaderSection(
                title = cartMeal.title,
                image = cartMeal.image
            )

            CartDescriptionSection(ingredients = cartMeal.ingredients)

            HorizontalDivider(
                thickness = 1.dp,
                color = mColors.tertiary
            )

            Spacer(modifier = Modifier.height(0.dp))
        }
    }
}