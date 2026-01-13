package com.nexifotech.edumanage.models

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource

data class ReportModel(
    val iconBackgroundColor: Color,
    val iconColor: Color,
    val icon: DrawableResource,
    val reportFor: String,
    val text: String,
    val description: String
)
