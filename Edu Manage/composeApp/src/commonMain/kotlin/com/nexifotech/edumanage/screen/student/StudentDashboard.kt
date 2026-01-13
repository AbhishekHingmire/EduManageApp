package com.nexifotech.edumanage.screen.student

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.StudentDashboardStatesModel
import com.nexifotech.edumanage.models.StudentDashboardUpcomingAssignmentModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.exam
import edumanage.composeapp.generated.resources.report
import org.jetbrains.compose.resources.painterResource

@Composable
fun StudentDashBoardScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = AppColors.background)
            .padding(14.dp,20.dp)
    ){
        //Header
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(AppColors.lightBlue, RoundedCornerShape(7.dp))
                .border(1.dp, AppColors.blueColor,RoundedCornerShape(7.dp))
                .padding(18.dp)
        ){
            ScreenHeaderText("Welcome back, Rahul Kumar!")
            Spacer(Modifier.height(5.dp))
            Text12Normal("Keep up the great work and stay motivated!")
            Spacer(Modifier.height(14.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(

                ){
                    Row(){
                        Icon(
                            painterResource(Res.drawable.app_white_logo),
                            "",
                            tint = AppColors.orengeColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(5.dp))
                        Text16Bold("15")
                    }
                    Text12Normal("Day Streak")
                }
                Spacer(Modifier.width(15.dp))
                Column(

                ){
                    Text16Bold("#5")
                    Text12Normal("Rank")
                }
            }
        }

        Spacer(Modifier.height(14.dp))
        //States
        Row(modifier = Modifier.fillMaxWidth()
        ){
            StudentDashboardStatesCard(StudentDashboardStatesModel("Assignments","2","Pending"), modifier = Modifier.weight(1f))
            Spacer(Modifier.width(10.dp))
            StudentDashboardStatesCard(StudentDashboardStatesModel("Avg Score","88%","+5% this month"), modifier = Modifier.weight(1f))
        }
        Spacer(Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()
        ){
            StudentDashboardStatesCard(StudentDashboardStatesModel("Study Time","3.5h","Today"), modifier = Modifier.weight(1f))
            Spacer(Modifier.width(10.dp))
            StudentDashboardStatesCard(StudentDashboardStatesModel("Badges","3","Earned"), modifier = Modifier.weight(1f))
        }
        Spacer(Modifier.height(20.dp))

        //Upcoming Exams
        val list1 = listOf(
            StudentDashboardUpcomingAssignmentModel("Quadratic Equations Practice","Mathematics","5/25/2025",20,205),
            StudentDashboardUpcomingAssignmentModel("Lab Report - Pendulum Experiment","Physics","5/23/2025",30,207)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text16Bold("Upcoming Assignments")
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text(
                    "View All",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.textColorPrimary
                )
            }
        }
        Spacer(Modifier.height(14.dp))
        list1.forEach { model ->
            StudentDashboardUpcomingAssignmentCard(model)
        }

        //Upcoming Exams
        val list2 = listOf(
            StudentDashboardUpcomingAssignmentModel("Mid-Term Math","Mathematics","5/25/2025",100,3),
            StudentDashboardUpcomingAssignmentModel("Science Unit Test","Science","5/23/2025",50,7)
        )
        Spacer(Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text16Bold("Upcoming Exams")
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text(
                    "View All",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.textColorPrimary
                )
            }
        }
        Spacer(Modifier.height(14.dp))
        list2.forEach {model ->
            StudentDashboardUpcomingExamCard(model)
        }
    }
}


@Composable
fun StudentDashboardStatesCard(model: StudentDashboardStatesModel,modifier: Modifier){
    Row(
         modifier
             .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
             .border(1.dp,AppColors.borderColor,RoundedCornerShape(7.dp))
             .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier.weight(1f)
        ){
            Text12Normal(model.title)
            Spacer(Modifier.height(2.dp))
            Text16Bold(model.data)
            Spacer(Modifier.height(3.dp))
            Text12Normal(model.text)
        }
        when (model.title) {
            "Assignments" -> {
                Icon(painterResource(Res.drawable.exam),
                    "",
                    tint = AppColors.orengeColor,
                    modifier = Modifier.size(15.dp)
                )
            }
            "Avg Score" ->{
                Icon(painterResource(Res.drawable.report),
                    "",
                    tint = AppColors.greenColor,
                    modifier = Modifier.size(15.dp)
                )
            }
            "Study Time" ->{
                Icon(painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.blueColor,
                    modifier = Modifier.size(15.dp)
                )
            }
            "Badges" ->{
                Icon(painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.orengeColor,
                    modifier = Modifier.size(15.dp)
                )
            }
        }

    }
}

@Composable
fun StudentDashboardUpcomingAssignmentCard(model: StudentDashboardUpcomingAssignmentModel){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.lightRed,RoundedCornerShape(7.dp))
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
                    "-${model.daysLeft}d",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        Spacer(Modifier.height(1.dp))
        Text12Normal(model.subject)
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

            Spacer(Modifier.width(15.dp))

            Icon(
                painterResource(Res.drawable.exam),
                "",
                tint = AppColors.textColorSecondary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text12Normal("${model.marks} marks")
        }

    }
}

@Composable
fun StudentDashboardUpcomingExamCard(model: StudentDashboardUpcomingAssignmentModel){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
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
                    .background(AppColors.greenColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text(
                    "${model.daysLeft} days",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
        Spacer(Modifier.height(1.dp))
        Text12Normal(model.subject)
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

            Spacer(Modifier.width(15.dp))

            Icon(
                painterResource(Res.drawable.exam),
                "",
                tint = AppColors.textColorSecondary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text12Normal("${model.marks} marks")
        }

    }
}