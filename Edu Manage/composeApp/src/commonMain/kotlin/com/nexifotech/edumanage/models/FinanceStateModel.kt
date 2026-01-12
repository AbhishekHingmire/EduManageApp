package com.nexifotech.edumanage.models

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource


data class FinanceStateModel(
    val title: String,
    val data: Int,
    val text: String,
    val icon: DrawableResource,
    val color: Color,
    val lightColor: Color
)
