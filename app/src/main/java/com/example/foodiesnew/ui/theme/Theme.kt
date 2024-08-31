package com.example.foodiesnew.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(

)

private val LightColorScheme = lightColorScheme(
    //Bottom bar
    surface = FullyWhite,
    onSurface = DarkCharcoal,
    secondaryContainer = PineGreenLighter,
    onSecondaryContainer = PineGreen,
    onSurfaceVariant = SlateGray,

    //Other
    background = FullyWhite,
    onBackground = DarkCharcoal,
    primary = CoralRed,
    onPrimary = DarkCharcoal,
    secondary = SlateGray,
    tertiary = Alabaster,
    onTertiary = DarkCharcoal
)

@Composable
fun FoodiesNewTheme(
    darkTheme: Boolean = false,
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