package com.nexifotech.edumanage.screen.teacher

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.TeacherPendingTaskModel
import com.nexifotech.edumanage.models.TeacherRecentAnnouncementModel
import com.nexifotech.edumanage.models.TeacherTodayClassesModel
import com.nexifotech.edumanage.screen.admin.DashboardQuickAction
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.attendance
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.exam
import edumanage.composeapp.generated.resources.student
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun TeacherDashboardScreen(){

    val todayClass = listOf(
        TeacherTodayClassesModel("Grade 10 - Mathematics","9:00 AM - 10:30 AM", 25,"Room 101"),
        TeacherTodayClassesModel("Grade 9 - Science","11:00 AM - 12:30 AM", 28,"Room 203"),
        TeacherTodayClassesModel("Grade 11 - Physics","2:00 PM - 3:30 PM", 22,"Lab 1"),
    )

    val pendingTaskList = listOf(
        TeacherPendingTaskModel("Grade Math Assignment - Grade 10",25,"Today"),
        TeacherPendingTaskModel("Math Attendance - Science Batch",1,"Today"),
        TeacherPendingTaskModel("Enter Marks - Unit Test",28,"Tomorrow"),
    )

    val recentList = listOf(
        TeacherRecentAnnouncementModel("Parent - Teacher Meeting","2024-02-15","High"),
        TeacherRecentAnnouncementModel("Mid-term Exam Schedule Released","2024-02-10","Medium")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = AppColors.background)
            .padding(14.dp, 0.dp, 14.dp, 2.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Teacher Dashboard")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Good morning! Here's your schedule for today.")

            Spacer(modifier = Modifier.height(20.dp))

            Text16Bold("My Classes Today")

            Spacer(modifier = Modifier.height(10.dp))
        }

        items(todayClass){
            TeacherTodayClassCard(it)
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))

            Text16Bold("Pending Tasks")

            Spacer(modifier = Modifier.height(10.dp))
        }

        items(pendingTaskList){
            TeacherPendingTask(it)
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))

            Text16Bold("Recent Announcements")

            Spacer(modifier = Modifier.height(10.dp))
        }

        items(recentList){
            TeacherRecentAnnouncment(it)
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))

            Column (modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(7.dp))
                .background(color = AppColors.cardBackground)
                .border(1.dp, color = AppColors.borderColor, shape = RoundedCornerShape(7.dp))
                .padding(16.dp)
            ){
                Text16Bold("Quick Actions")

                Spacer(modifier = Modifier.height(10.dp))

                Row (modifier = Modifier.fillMaxWidth()){

                    TeacherQuickAction(
                        text = "Mark Attendance",
                        color = AppColors.blueColor,
                        image = Res.drawable.attendance,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    TeacherQuickAction(
                        text = "Post Assignment",
                        color = AppColors.greenColor,
                        image = Res.drawable.exam,
                        modifier = Modifier.weight(1f)
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Row (modifier = Modifier.fillMaxWidth()){

                    TeacherQuickAction(
                        text = "Manage Exams",
                        color = AppColors.orengeColor,
                        image = Res.drawable.calendar,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    TeacherQuickAction(
                        text = "View Students",
                        color = AppColors.blueColor,
                        image = Res.drawable.student,
                        modifier = Modifier.weight(1f)
                    )

                }
            }
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}

@Composable
fun TeacherTodayClassCard(model: TeacherTodayClassesModel){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier
                .weight(1f)
        ){
            Text14SemiBold(model.className)

            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(Res.drawable.calendar),
                    "",
                    tint = AppColors.textColorSecondary,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(2.dp))
                Text12Normal(model.timing)
                Spacer(Modifier.width(10.dp))
                Icon(
                    painter = painterResource(Res.drawable.student),
                    "",
                    tint = AppColors.textColorSecondary,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(2.dp))
                Text12Normal("${model.studentCount} students")
                Spacer(Modifier.width(10.dp))
                Text12Normal(model.roomNo)
            }
        }

        Box(
            modifier = Modifier
                .background(AppColors.primaryColor,RoundedCornerShape(12.dp))
                .padding(10.dp,7.dp)
        ){
            Text(
                "Start",
                fontSize = 12.sp,
                color = Color.White
            )
        }

    }
}

@Composable
fun TeacherPendingTask(model: TeacherPendingTaskModel){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.lightOrange, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.orengeColor, RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier
                .weight(1f)
        ){
            Text14SemiBold(model.task)

            Spacer(Modifier.height(5.dp))
            Text12Normal("${model.item} items  |  Due: ${model.dueDate}")
        }

        Box(
            modifier = Modifier
                .background(AppColors.background,RoundedCornerShape(12.dp))
                .border(1.dp, AppColors.borderColor,RoundedCornerShape(12.dp))
                .padding(10.dp,7.dp)
        ){
            Text12Primary("View")
        }

    }
}

@Composable
fun TeacherRecentAnnouncment(model: TeacherRecentAnnouncementModel){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier
                .weight(1f)
        ){
            Text(
                model.announcements,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.textColorPrimary
            )

            Spacer(Modifier.height(5.dp))
            Text(
                model.date,
                fontSize = 12.sp,
                color = AppColors.textColorSecondary
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(
                    when(model.priority){
                        "High" -> AppColors.lightRed
                        "Medium" -> AppColors.lightBlue
                        else -> AppColors.lightBlue
                    }
                )
                .padding(10.dp,7.dp)
        ){
            Text(
                model.priority,
                fontSize = 12.sp,
                color = when(model.priority){
                        "High" -> AppColors.redColor
                        "Medium" -> AppColors.blueColor
                        else -> AppColors.blueColor
                    }

            )
        }

    }
}


@Composable
fun TeacherQuickAction(
    text : String,
    color : Color,
    image : DrawableResource,
    modifier: Modifier = Modifier
){
    Column(
        modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color)
            .padding(12.dp,12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painterResource(image),
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier.size(15.dp)
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color =  Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}