package com.nexifotech.edumanage.models

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource

data class ReportTabModel(
    val backgroundColor: Color,
    val iconColor: Color,
    val icon: DrawableResource,
    val text: String,
    val description: String
)
