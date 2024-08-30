package com.example.foodiesnew.presentation.order_screen.meal_bottom_sheet.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun DescriptionSection(
    ingredients: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = mColors.tertiary
        )

        Text(
            text = ingredients,
            style = mTypography.bodyLarge.copy(
                lineBreak = LineBreak.Paragraph
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}