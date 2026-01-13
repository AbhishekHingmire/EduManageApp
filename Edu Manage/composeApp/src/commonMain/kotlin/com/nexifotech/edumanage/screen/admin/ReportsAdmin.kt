package com.nexifotech.edumanage.screen.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.ReportModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.attendance
import edumanage.composeapp.generated.resources.batch
import edumanage.composeapp.generated.resources.report
import edumanage.composeapp.generated.resources.rupee
import edumanage.composeapp.generated.resources.student
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable

fun AdminReportScreen(){

    var list = listOf(
        ReportModel(AppColors.lightBlue, AppColors.blueColor,Res.drawable.student,"Student","Student Enrollment Report","Complete details of all enrolled students"),
        ReportModel(AppColors.lightGreen, AppColors.greenColor,Res.drawable.attendance,"Attendance","Attendance Summary","Monthly attendance statistics and trends"),
        ReportModel(AppColors.lightOrange, AppColors.orengeColor,Res.drawable.rupee,"Finance","Fee Collection Report","Detailed fee payment and collection status"),
        ReportModel(AppColors.lightGreen, AppColors.greenColor,Res.drawable.report,"Academics","Performance Analytics","Student academic performance and grades"),
        ReportModel(AppColors.lightRed, AppColors.redColor,Res.drawable.app_white_logo,"Teachers","Teacher Performance","Teacher workload and performance metrics"),
        ReportModel(AppColors.lightBlue, AppColors.blueColor,Res.drawable.batch,"Batches","Batch-wise Analysis","Comprehensive batch-wise performance report")
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColors.background)
            .padding(14.dp, 0.dp, 14.dp, 2.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Report & Analytics")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Comprehensive insights and data reports")

            Spacer(modifier = Modifier.height(20.dp))

            Text16Bold("Available Reports")
            Spacer(modifier = Modifier.height(14.dp))
        }


        items(list){
            ReportCard(
                it.iconBackgroundColor,
                it.iconColor,
                it.icon,
                it.reportFor,
                it.text,
                it.description
            )
        }
    }
}

@Composable
fun ReportCard(iconBackgroundColor: Color, iconColor: Color, icon: DrawableResource, reportFor: String, text: String,description: String){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(iconBackgroundColor,RoundedCornerShape(7.dp)),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(icon),
                    "",
                    tint = iconColor,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .background(AppColors.cardBackground, RoundedCornerShape(20.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text12Primary(reportFor)
            }
        }
        Spacer(Modifier.height(12.dp))
        Text14SemiBold(text)
        Spacer(Modifier.height(5.dp))
        Text12Normal(description)
        Spacer(Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Box(
                modifier = Modifier.height(40.dp)
                    .weight(1f)
                    .background(AppColors.background, RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text14Normal("View")
            }

            Spacer(Modifier.width(10.dp))

            Box(
                modifier = Modifier.height(40.dp)
                    .weight(1f)
                    .background(AppColors.background, RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text14Normal("Download")
            }
        }
    }
}