package com.nexifotech.edumanage.screen.teacher

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.AddButton
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.models.TeacherCreateExamModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.delete
import edumanage.composeapp.generated.resources.edit
import edumanage.composeapp.generated.resources.exam
import edumanage.composeapp.generated.resources.eye
import org.jetbrains.compose.resources.painterResource

@Composable
fun TeacherExamScreen(){

    val examList = listOf(
        TeacherCreateExamModel("Mid-Term Exam","Mid-Type","Mathematics",1,"March 15th, 2024","120 minutes","100"),
        TeacherCreateExamModel("Unit Test 1","Unit-Test","Science",2,"March 20th, 2024","60 minutes","50")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(AppColors.background)
            .padding(14.dp,0.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Exams & Assessments")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Create and manage exams, enter marks and publish results")

            AddButton("Create Exam",{

            })

        }

        items(examList){
            TeacherCreateExamCard(it)
        }
    }
}

@Composable
fun TeacherCreateExamCard(model: TeacherCreateExamModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Text14SemiBold(model.examName)
        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Box(
                modifier = Modifier
                    .background(AppColors.lightBlue, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(model.examType, fontSize = 12.sp,color = AppColors.primaryColor)
            }

            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(AppColors.cardBackground, RoundedCornerShape(20.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(model.subject, fontSize = 12.sp,color = AppColors.textColorPrimary)
            }
        }
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text12Normal("Date")
                Spacer(Modifier.height(2.dp))
                Text12Primary(model.date)
            }
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text12Normal("Duration")
                Spacer(Modifier.height(2.dp))
                Text12Primary(model.duration)
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text12Normal("Total Mark")
                Spacer(Modifier.height(2.dp))
                Text12Primary(model.totalMarks)
            }
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text12Normal("Batches")
                Spacer(Modifier.height(2.dp))
                Text12Primary(model.batches.toString())
            }
        }

        Spacer(Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),

        ){
            Row(
                modifier = Modifier.weight(1f)
                    .height(40.dp)
                    .background(AppColors.primaryColor,RoundedCornerShape(7.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    painterResource(Res.drawable.exam),
                    "",
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    "Enter Marks",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }

            Spacer(Modifier.width(10.dp))

            Row(
                modifier = Modifier.weight(1f)
                    .height(40.dp)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    painterResource(Res.drawable.eye),
                    "",
                    tint = AppColors.textColorPrimary,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    "View Results",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = AppColors.textColorPrimary
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier )

        Spacer(Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier.weight(1f)
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    painterResource(Res.drawable.edit),
                    "",
                    tint = AppColors.textColorPrimary,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    "Edit",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = AppColors.textColorPrimary
                )
            }

            Spacer(Modifier.width(10.dp))

            Row(
                modifier = Modifier.weight(1f)
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    painterResource(Res.drawable.delete),
                    "",
                    tint = AppColors.redColor,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    "Delete",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = AppColors.redColor
                )
            }
        }
    }
}