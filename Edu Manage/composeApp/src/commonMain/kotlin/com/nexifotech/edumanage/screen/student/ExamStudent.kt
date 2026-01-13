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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.StudentUpcomingExamModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.calendar
import org.jetbrains.compose.resources.painterResource

@Composable
fun StudentExamScreen(){

    var selectedTab by remember{ mutableStateOf(0) }
    val mainTabs = listOf("Upcoming","Results","Performance")
    var resultTabs by remember { mutableStateOf(0) }
    val resultTabsList = listOf("This Week","This Month","All")


    val upcomingExamList = listOf(
        StudentUpcomingExamModel("Mathematics Unit Test - 4", "209","May 20, 2025","10:00 AM - 12:00 PM"),
        StudentUpcomingExamModel("Science Mid-term", "209","May 20, 2025","10:00 AM - 12:00 PM")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(AppColors.background)
            .padding(14.dp,0.dp)
    ){
        //Header
        item {
            Spacer(modifier = Modifier.height(20.dp))
            ScreenHeaderText("My Exams")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Track your exam schedule and results")
            Spacer(modifier = Modifier.height(20.dp))
        }

        //Main Tabs
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
                    .padding(5.dp)
            ){
                mainTabs.forEachIndexed { index, string ->
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
                items(upcomingExamList){
                    StudentExamUpcomingCard(it)
                }
            }
            1->{
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
                            .padding(5.dp)
                    ){
                        resultTabsList.forEachIndexed { index, string ->
                            val isSelected = index == resultTabs

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .background(
                                        if (isSelected) AppColors.primaryColor else Color.Transparent,
                                        RoundedCornerShape(7.dp)
                                    )
                                    .clickable{resultTabs = index}
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
                when(resultTabs){
                    0->{

                    }
                    1->{

                    }
                    2->{
                        item {
                            StudentExamResultCard()
                            StudentExamResultCard()
                            StudentExamResultCard()
                        }
                    }
                }
            }
            2->{
                item { StudentPerformanceCard()}
            }
        }
    }
}

@Composable
fun StudentExamUpcomingCard(model: StudentUpcomingExamModel){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp,AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier.weight(1f)
        ){
            Box(
                modifier = Modifier
                    .background(AppColors.redColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text(
                    "-${model.dayLeft}d",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )

            }
            Spacer(Modifier.height(5.dp))
            Text14SemiBold(model.title)
            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painterResource(Res.drawable.calendar),
                    "",
                    tint = AppColors.textColorSecondary,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text12Normal("${model.date} | ${model.time}")
            }
        }
        Box(
            modifier = Modifier
                .background(AppColors.background,RoundedCornerShape(7.dp))
                .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                .padding(10.dp,8.dp),
            contentAlignment = Alignment.Center
        ){
            Text12Primary("View Details")
        }
    }
}

@Composable
fun StudentPerformanceCard(){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Text16Bold("Overall Performance")
        Spacer(Modifier.height(20.dp))
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Box(
                modifier = Modifier.height(120.dp)
                    .width(120.dp)
                    .background(AppColors.lightBlue,RoundedCornerShape(50))
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    "85",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.textColorPrimary
                )
            }
            Spacer(Modifier.height(10.dp))
            Text12Normal("Overall Performance Score")
            Spacer(Modifier.height(5.dp))
            Text(
                "+8% from last term",
                fontSize = 12.sp,
                color = AppColors.greenColor
            )
        }

        Spacer(Modifier.height(20.dp))
        Text14SemiBold("Subject-wise Performance")
        Spacer(Modifier.height(10.dp))
        Text12Primary("Mathematics: 85%")
        Spacer(Modifier.height(5.dp))
        Text12Primary("Physics: 78%")
        Spacer(Modifier.height(5.dp))
        Text12Primary("English: 92%")

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
                .background(AppColors.lightGreen,RoundedCornerShape(7.dp))
                .border(1.dp, AppColors.greenColor,RoundedCornerShape(7.dp))
                .padding(16.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.greenColor,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text("Strengths",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.greenColor)
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.greenColor,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text12Primary("English - Consistently scoring >90%")
            }
            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.greenColor,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text12Primary("Mathematics - Strong problem solving")
            }
        }

        Spacer(Modifier.height(15.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
                .background(AppColors.lightOrange,RoundedCornerShape(7.dp))
                .border(1.dp, AppColors.orengeColor,RoundedCornerShape(7.dp))
                .padding(16.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.orengeColor,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text("Focus Areas",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.orengeColor)
            }
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.orengeColor,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text12Primary("Physics - Practice more numericals")
            }
            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.orengeColor,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text12Primary("Chemistry - Revise chemical equations")
            }
        }
    }
}

@Composable
fun StudentExamResultCard(){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp,AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                modifier = Modifier.weight(1f)
            ){
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier
                            .background(AppColors.cardBackground, RoundedCornerShape(20.dp))
                            .border(1.dp,AppColors.textColorPrimary,RoundedCornerShape(20.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ){
                        Text12Primary("Mathematics")
                    }
                    Spacer(Modifier.width(10.dp))
                    Box(modifier = Modifier.width(25.dp)
                        .height(25.dp)
                        .background(AppColors.blueColor,RoundedCornerShape(7.dp)),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            "A",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
                Spacer(Modifier.height(5.dp))
                Text14SemiBold("Mid-term Mathematics")
            }
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.End
            ){
                Row (modifier = Modifier,
                    verticalAlignment = Alignment.Bottom
                ){
                    Text14SemiBold("85")
                    Text("/100",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = AppColors.textColorSecondary)
                }
                Spacer(Modifier.height(5.dp))
                Text12Normal("85%")
            }
        }
        Spacer(Modifier.height(5.dp))
        Text12Normal("May 15, 2025  |  Class Avg: 72%")
    }
}