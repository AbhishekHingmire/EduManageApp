package com.nexifotech.edumanage.screen.student

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.theme.AppColors

@Composable
fun StudentAttendanceScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = AppColors.background)
            .padding(14.dp,20.dp)
    ){
        ScreenHeaderText("My Attendance")
        Spacer(Modifier.height(5.dp))
        ScreenSubHeaderText("View your attendance records")
        Spacer(Modifier.height(14.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
                .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
                .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                .padding(16.dp,18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                "87%",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = AppColors.greenColor
            )
            Spacer(Modifier.height(5.dp))
            Text12Normal("Overall Attendance")

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Column (
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        "52",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = AppColors.greenColor
                    )

                    Text12Normal("Present")
                }
                Column (
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        "6",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = AppColors.redColor
                    )

                    Text12Normal("Absent")
                }
                Column (
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        "2",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = AppColors.orengeColor
                    )

                    Text12Normal("Leave")
                }
            }
        }
    }

}