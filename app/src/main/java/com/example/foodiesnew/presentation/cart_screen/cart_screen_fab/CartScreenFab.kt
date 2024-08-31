package com.example.foodiesnew.presentation.cart_screen.cart_screen_fab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.painterResource
import com.example.foodiesnew.R
import com.example.foodiesnew.presentation.common_bars.snackbars.SnackbarController
import com.example.foodiesnew.presentation.common_bars.snackbars.SnackbarEvent
import com.example.foodiesnew.ui.theme.mColors
import com.example.foodiesnew.ui.theme.mTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CartScreenFab(
    currentRoute: String,
    scope: CoroutineScope = rememberCoroutineScope()
) {
    AnimatedVisibility(
        visible = currentRoute == "CartScreenRoute",
        enter = slideInVertically(tween(300)) + fadeIn(tween(300)),
        exit = slideOutVertically(tween(300)) + fadeOut(tween(300))
    ) {
        ExtendedFloatingActionButton(
            containerColor = mColors.primary,
            text = {
                Text(
                    text = "Order",
                    style = mTypography.bodyLarge
                )
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart_outlined),
                    contentDescription = null
                )
            },
            onClick = {
                scope.launch {
                    SnackbarController.sendEvent(SnackbarEvent(
                        message = "This part is hardcoded :)"
                    ))
                }
            }
        )
    }
}