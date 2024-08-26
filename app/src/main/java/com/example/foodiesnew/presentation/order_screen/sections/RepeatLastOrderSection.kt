package com.example.foodiesnew.presentation.order_screen.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.R
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun RepeatLastOrderSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 4.dp,
                start = 16.dp,
                end = 16.dp
            )
            .background(
                color = mColors.tertiary,
                shape = mShapes.extraSmall
            )
            .padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_repeat_outlined),
            contentDescription = null,
        )

        Text(
            text = "Repeat last order",
            style = mTypography.bodyLarge
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        Icon(
            tint = Color.Unspecified,
            painter = painterResource(id = R.drawable.ic_burger_multicolor),
            contentDescription = null
        )
    }
}