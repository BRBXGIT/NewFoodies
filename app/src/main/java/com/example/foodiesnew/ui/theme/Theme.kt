package com.example.foodiesnew.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    //Bottom bar
    surface = FullyWhite,
    onSurface = SlateGray,
    secondaryContainer = PineGreen,
    onSecondaryContainer = PineGreenLighter,
    onSurfaceVariant = SlateGray,

    //Other
    background = FullyWhite,
    onBackground = DarkCharcoal,
    primary = CoralRed,
    onPrimary = DarkCharcoal,
    secondary = SlateGray,
    tertiary = Alabaster
)

private val LightColorScheme = lightColorScheme(

)

@Composable
fun FoodiesNewTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

val mColors @Composable get() = MaterialTheme.colorScheme
val mTypography @Composable get() = MaterialTheme.typography
val mShapes @Composable get() = MaterialTheme.shapes