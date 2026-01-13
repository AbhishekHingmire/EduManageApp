package com.nexifotech.edumanage.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.theme.AppColors

@Composable
fun ScreenHeaderText(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = AppColors.textColorPrimary
    )
}

@Composable
fun ScreenSubHeaderText(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = AppColors.textColorSecondary
    )
}


@Composable
fun Text16Bold(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = AppColors.textColorPrimary
    )
}

@Composable
fun Text14SemiBold(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = AppColors.textColorPrimary
    )
}

@Composable
fun Text14Normal(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = AppColors.textColorPrimary
    )
}

@Composable
fun Text12Normal(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = AppColors.textColorSecondary
    )
}

@Composable
fun Text12Primary(text: String){
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = AppColors.textColorPrimary
    )
}