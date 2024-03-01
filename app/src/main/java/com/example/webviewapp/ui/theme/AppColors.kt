package com.example.webviewapp.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AppColors(
    primary: Primary,
    secondary: Secondary
) {
    var primary by mutableStateOf(primary)
    var secondary by mutableStateOf(secondary)
}

object Primary {
    val pink = Color(0xFFFF6667)
    val dark = Color(0xFF3f3f3f)
    val white = Color(0xFFFFFFFF)
}

object Secondary {
    val pink = Color(0xFFFFB2B3)
    val dark = Color(0xFF9a9a9a)
}

fun lightColors(
    primary: Primary = Primary,
    secondary: Secondary = Secondary
) : AppColors =
    AppColors(
        primary = primary,
        secondary = secondary
    )

val LocalColors = staticCompositionLocalOf { lightColors() }