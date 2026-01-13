package com.nexifotech.edumanage.screen.student

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.StudentCompleteAssignmentModel
import com.nexifotech.edumanage.models.StudentPendingAssinmentModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.eye
import org.jetbrains.compose.resources.painterResource

@Composable
fun StudentAssignmentScreen(){

    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Pending","Completed")

    val pendingAssignmentList = listOf(
        StudentPendingAssinmentModel("Quadratic Equations Practice","May 25, 11:59 PM","20",204,"Mathematics"),
        StudentPendingAssinmentModel("Lab Report - Pendulum Experiment","May 23, 11:59 PM","30",206,"Physics")
    )
    val completeAssignmentList = listOf(
        StudentCompleteAssignmentModel("Essay: Climate Change Impact","May 19, 2025","English",25,22)
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(AppColors.background)
            .padding(14.dp,0.dp)
    ){
        //Header
        item {
            Spacer(modifier = Modifier.height(20.dp))
            ScreenHeaderText("Assignments")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Track your assignments and submissions")
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Row(modifier = Modifier.fillMaxWidth()){
                StudentAssignmentStates("Pending",2, modifier = Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                StudentAssignmentStates("Completed",1,modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        //Tabs
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
                    .padding(5.dp)
            ){
                tabs.forEachIndexed { index, string ->
                    val isSelected = index == selectedTab

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                if (isSelected) AppColors.primaryColor else Color.Transparent,
                                RoundedCornerShape(7.dp)
                            )
                            .clickable{selectedTab = index}
                            .padding(7.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = string,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isSelected) Color.White else AppColors.textColorPrimary,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }

        when(selectedTab){
            0->{
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painterResource(Res.drawable.app_white_logo),
                            "",
                            tint = AppColors.redColor,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(Modifier.width(10.dp))
                        Text16Bold("Pending Assignments")
                    }
                    Spacer(Modifier.height(14.dp))
                }
                items(pendingAssignmentList){
                    PendingAssignmentCard(it)
                }
            }

            1->{
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            painterResource(Res.drawable.app_white_logo),
                            "",
                            tint = AppColors.greenColor,
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(Modifier.width(10.dp))
                        Text16Bold("Completed Assignments")
                    }
                    Spacer(Modifier.height(14.dp))
                }
                items(completeAssignmentList){
                    CompleteAssignmentCard(it)
                }
            }
        }
    }
}

@Composable
fun StudentAssignmentStates(title: String,data: Int,modifier: Modifier ){
    Column(
        modifier = modifier
            .background(color = AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp,AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Text12Normal(title)
        Spacer(Modifier.height(5.dp))
        Text(
            text = data.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = when(title){
                "Pending" -> AppColors.redColor
                "Completed" -> AppColors.greenColor
                else -> AppColors.textColorPrimary
            }
        )
    }
}

@Composable
fun PendingAssignmentCard(model: StudentPendingAssinmentModel){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.lightRedBackground,RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.redColor,RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text14SemiBold(model.title)
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .background(AppColors.redColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text(
                    model.subject,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painterResource(Res.drawable.calendar),
                "",
                tint = AppColors.textColorSecondary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text12Normal(model.date)
            Spacer(Modifier.width(10.dp))
            Icon(
                painterResource(Res.drawable.calendar),
                "",
                tint = AppColors.textColorSecondary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text12Normal("${model.marks} marks")

        }
        Spacer(Modifier.height(5.dp))
        Text(
            "Due in - ${model.dueDays} days!",
            fontSize = 12.sp,
            color = AppColors.redColor
        )
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(AppColors.background,RoundedCornerShape(7.dp))
                .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                .padding(0.dp,10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(painterResource(Res.drawable.eye),"", tint = AppColors.textColorPrimary, modifier = Modifier.size(15.dp))
            Spacer(Modifier.width(10.dp))
            Text14Normal("View Details")
        }


    }
}

@Composable
fun CompleteAssignmentCard(model: StudentCompleteAssignmentModel){
    Column(modifier = Modifier
        .background(color = AppColors.lightGreen,RoundedCornerShape(7.dp))
        .border(1.dp,AppColors.greenColor,RoundedCornerShape(7.dp))
        .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text14SemiBold(model.title)
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .background(AppColors.lightGreen, RoundedCornerShape(20.dp))
                    .border(1.dp,AppColors.greenColor,RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text(
                    model.subject,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.greenColor
                )
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text12Normal("Completed: ${model.completeDate}")
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .background(AppColors.greenColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text(
                    "${model.marksObtain}/${model.totalMarks}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(AppColors.background,RoundedCornerShape(7.dp))
                .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                .padding(0.dp,10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(painterResource(Res.drawable.eye),"", tint = AppColors.textColorPrimary, modifier = Modifier.size(15.dp))
            Spacer(Modifier.width(10.dp))
            Text14Normal("View Details")
        }
    }
}