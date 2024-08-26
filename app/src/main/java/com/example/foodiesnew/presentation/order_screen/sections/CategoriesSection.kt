package com.example.foodiesnew.presentation.order_screen.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodiesnew.R
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mShapes
import com.example.foodiesnew.ui.theme.mTypography

data class CategoryData(
    val icon: Int,
    val iconChosen: Int,
    val title: String,
)

@Composable
fun CategoriesSection() {
    val categories = listOf(
        CategoryData(
            icon = R.drawable.ic_menu_oitlined,
            iconChosen = R.drawable.ic_menu_filled,
            title = "Menu"
        ),
        CategoryData(
            icon = R.drawable.ic_heart_outlined,
            iconChosen = R.drawable.ic_heart_filled,
            title = "Awards"
        ),
        CategoryData(
            icon = R.drawable.ic_qr_code_outlined,
            iconChosen = R.drawable.ic_qr_code_filled,
            title = "Code"
        ),
        CategoryData(
            icon = R.drawable.ic_balloon_outlined,
            iconChosen = R.drawable.ic_baloon_filled,
            title = "Proms"
        )
    )

    var chosenCategory by rememberSaveable { mutableIntStateOf(0) }
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        contentPadding = PaddingValues(
            horizontal = 16.dp
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(categories) { index, category ->
            Category(
                icon = category.icon,
                iconChosen = category.iconChosen,
                title = category.title,
                isChosen = chosenCategory == index,
                onClick = { chosenCategory = index }
            )
        }
    }
}

@Composable
fun Category(
    icon: Int,
    iconChosen: Int,
    title: String,
    isChosen: Boolean,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(mShapes.small)
            .clickable {
                onClick()
            }
            .padding(4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(42.dp)
                .shadow(
                    elevation = if (isChosen) 2.dp else 0.dp,
                    shape = CircleShape
                )
                .background(
                    color = if (isChosen) mColors.surface else mColors.tertiary,
                    shape = CircleShape
                )
        ) {
            Icon(
                painter = painterResource(id = if(isChosen) iconChosen else icon),
                contentDescription = null,
                tint = if(isChosen) mColors.primary else mColors.onTertiary
            )
        }

        Text(
            text = title,
            style = mTypography.bodySmall,
            color = mColors.onBackground,
            fontWeight = if(isChosen) FontWeight.Bold else FontWeight.Normal
        )
    }
}