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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.TeacherWeeklyScheduleModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.student
import org.jetbrains.compose.resources.painterResource

@Composable
fun TeacherTimeTableScreen(){

    val weeklyScheduleList = listOf(
        TeacherWeeklyScheduleModel("Grade 10 - Mathematics", "Math", listOf("Mon","Wed","Fri"),"09:00 - 10:30",25),
        TeacherWeeklyScheduleModel("Grade 11 - Physics", "Phy", listOf("Mon","Wed","Fri"),"14:00 - 15:30",20)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = AppColors.background)
            .padding(14.dp,0.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Teacher Dashboard")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Good morning! Here's your schedule for today.")

            Spacer(modifier = Modifier.height(20.dp))

            Text16Bold("Weekly Schedule")

            Spacer(modifier = Modifier.height(10.dp))
        }

        items(weeklyScheduleList){
            WeeklyScheduleCard(it)
        }
    }
}


@Composable
fun WeeklyScheduleCard(model: TeacherWeeklyScheduleModel){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text14SemiBold(model.title)

                Spacer(Modifier.height(5.dp))

                Text12Normal(model.subject)
            }

            Row(
                modifier = Modifier
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(10.dp,7.dp)
            ){
                Icon(
                    painterResource(Res.drawable.app_white_logo),
                    "",
                    tint = AppColors.textColorPrimary,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(7.dp))
                Text12Primary("Change")
            }
        }

        Spacer(Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(
                painterResource(Res.drawable.calendar),
                "",
                tint = AppColors.textColorPrimary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(7.dp))

            model.days.forEach { string ->
                Text12Primary("${string}, ")
            }
            Spacer(Modifier.width(10.dp))
            Icon(
                painterResource(Res.drawable.calendar),
                "",
                tint = AppColors.textColorPrimary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(7.dp))
            Text12Primary(model.time)
        }

        Spacer(Modifier.height(7.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painterResource(Res.drawable.student),
                "",
                tint = AppColors.textColorPrimary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(7.dp))
            Text12Primary("${model.studentCount} students")
        }
    }
}
