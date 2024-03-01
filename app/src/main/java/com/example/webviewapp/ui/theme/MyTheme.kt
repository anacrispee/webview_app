package com.example.webviewapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object MyTheme {
    val colors: AppColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

    val typography: AppTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current
}