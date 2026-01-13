package com.nexifotech.edumanage.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.theme.AppColors

@Composable
fun AddButton(text: String, onClick:()-> Unit){
    // Add Teachers Button
    Spacer(Modifier.height(20.dp))

    Row(
        modifier = Modifier.fillMaxWidth()
            .height(40.dp)
            .background(AppColors.primaryColor,RoundedCornerShape(10.dp))
            .clickable(true, onClick = {onClick()}),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "+ ",
            fontSize = 22.sp,
            color = Color.White
        )

        Spacer(Modifier.width(5.dp))

        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.White
        )
    }

    Spacer(Modifier.height(20.dp))
}