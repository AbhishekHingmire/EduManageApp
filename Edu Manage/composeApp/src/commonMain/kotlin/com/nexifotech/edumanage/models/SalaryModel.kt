package com.nexifotech.edumanage.models

import androidx.compose.ui.graphics.Color

data class SalaryModel(
    val teacher: String,
    val salary:Int,
    val lastPaid: String,
    val status: String
)
