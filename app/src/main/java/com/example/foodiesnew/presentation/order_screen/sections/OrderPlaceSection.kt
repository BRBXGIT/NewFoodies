package com.example.foodiesnew.presentation.order_screen.sections

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.R
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

@Composable
fun OrderPlaceSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                color = mColors.tertiary,
                shape = mShapes.extraSmall
            )
            .padding(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var chosenOrderType by rememberSaveable { mutableIntStateOf(0) }
        OrderPlace(
            text = "In restaurant",
            icon = R.drawable.ic_home_outlined,
            iconChosen = R.drawable.ic_home_filled,
            isChosen = chosenOrderType == 0,
            onClick = { chosenOrderType = 0 }
        )

        OrderPlace(
            text = "Delivery",
            icon = R.drawable.ic_delivery_outlined,
            iconChosen = R.drawable.ic_delivery_filled,
            isChosen = chosenOrderType == 1,
            onClick = { chosenOrderType = 1 }
        )
    }
}

@Composable
fun RowScope.OrderPlace(
    text: String,
    icon: Int,
    iconChosen: Int,
    isChosen: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .weight(0.5f)
            .background(
                color = if (isChosen) mColors.surface else Color.Transparent,
                shape = mShapes.extraSmall
            )
            .noRippleClickable { onClick() }
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = if(isChosen) iconChosen else icon),
                contentDescription = null,
                tint = if(isChosen) mColors.primary else mColors.onTertiary
            )

            Text(
                text = text,
                style = mTypography.bodyMedium,
            )
        }
    }
}

//Modifier extension for clicking without ripple
@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}