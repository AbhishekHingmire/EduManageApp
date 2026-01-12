package com.nexifotech.edumanage.screen.admin

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AppBarColumn
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.AddButton
import com.nexifotech.edumanage.common.DropDown
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.models.CreateExamModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.attendance
import edumanage.composeapp.generated.resources.batch
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.delete
import edumanage.composeapp.generated.resources.edit
import edumanage.composeapp.generated.resources.report
import edumanage.composeapp.generated.resources.student
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdminExamsScreen(){

    var month by remember { mutableStateOf("This Month")}
    var types by remember { mutableStateOf("All Types")}
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Completed (105)","Upcoming (0)")

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = AppColors.background)
        .padding(14.dp,0.dp,14.dp,2.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))
            ScreenHeaderText("Exams Management")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Create and manage all exams across batches")

            AddButton("Create Exam", onClick = {})


        }

        item {
            val examList = listOf(
                CreateExamModel("Mathematics", date = "10 December, 2025","120 mins",100,40,listOf("Mathematics")),
                CreateExamModel("Physics", date = "13 December, 2025","120 mins",100,40,listOf("Physics")),
                CreateExamModel("December Test", date = "30 December, 2025","120 mins",100,40,listOf("Mathematics","Hindi","English","Science")),
            )

            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                AdminExamStateReusable("Total Exams",105, Res.drawable.attendance, AppColors.blueColor,
                    Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                AdminExamStateReusable("Completed",105, Res.drawable.app_white_logo, AppColors.greenColor,
                    Modifier.weight(1f))
            }
            Spacer(Modifier.height(10.dp))
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                AdminExamStateReusable("Upcoming",0, Res.drawable.calendar, AppColors.orengeColor,
                    Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                AdminExamStateReusable("This Month",105, Res.drawable.report, AppColors.primaryColor,
                    Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Text14Normal("Month")
            Spacer(modifier = Modifier.height(5.dp))
            DropDown(
                list = listOf(
                    "All Months",
                    "This Month",
                    "January",
                    "February",
                    "March",
                    "April",
                    "May",
                    "June",
                    "July",
                    "August",
                    "September",
                    "October",
                    "November",
                    "December"
                ),
                modifier = Modifier,
                value = month,
                finalValue = {
                    month=it
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text14Normal("Types")
            Spacer(modifier = Modifier.height(5.dp))
            DropDown(
                list = listOf(
                    "All Types",
                    "Weekly Test",
                    "Unit Test",
                    "Quarterly",
                    "Half Yearly",
                    "Final Exam"
                ),
                modifier = Modifier,
                value = types,
                finalValue = {
                    types = it
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(14.dp))

            Row(modifier = Modifier.fillMaxWidth()
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
                    AdminCompletedExamCard("Weekly Test 5","January 34th, 2025",60,50,"Grade 6-A","Weekly Test","Science","Pending Publish")
                }
            }
            1->{
                item {
                    AdminUpcomingExamCard("Weekly Test 5","January 34th, 2025",60,50,"Grade 6-A","Weekly Test","Science")
                }
            }
            else -> {

            }
        }
    }
}

@Composable
fun CreateExamCard(examModel: CreateExamModel){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
        .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
        .padding(16.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                examModel.examName,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = AppColors.textColorPrimary,
                modifier = Modifier.weight(1f)
            )

            // Ongoing Label
            Box(
                modifier = Modifier
                    .background(AppColors.primaryColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text("Ongoing", color = Color.White, fontSize = 12.sp)
            }
        }

        Spacer(Modifier.height(5.dp))

        LazyRow(){
            items(examModel.subjects){
                Box(
                    modifier = Modifier
                        .padding(0.dp,0.dp,5.dp,0.dp)
                        .background(AppColors.background, RoundedCornerShape(20.dp))
                        .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text12Primary(it)
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        ExamDataCompose(Res.drawable.calendar,"Date:", examModel.date)
        ExamDataCompose(Res.drawable.calendar,"Duration:", examModel.duration)

        Row(modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically){
            ExamDataCompose(Res.drawable.calendar,"Total Marks:",examModel.totalMarks.toString())

            Spacer(Modifier.width(5.dp))

            Text12Normal("| Passing: ")
            Text12Primary("${examModel.passingMarks}")
        }

    }
}

@Composable
fun ExamDataCompose(icon: DrawableResource, text1: String, text2: String){
    Row(){
        Icon(
            painter = painterResource(icon),
            "",
            tint = AppColors.textColorSecondary,
            modifier = Modifier.size(12.dp)
        )

        Spacer(Modifier.width(5.dp))

        Text12Normal("$text1:")

        Text12Primary(" $text2")

        Spacer(Modifier.height(3.dp))
    }
}

@Composable
fun AdminCompletedExamCard(title: String,date: String,duration: Int,totalMarks: Int,batch: String, testType: String, subject: String,publish: String){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ){
        Text14SemiBold(title)
        Spacer(Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .background(AppColors.lightOrange,RoundedCornerShape(20.dp))
                    .padding(12.dp,4.dp)
            ){
                Text(testType, fontSize = 12.sp,  color = AppColors.orengeColor)
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(AppColors.cardBackground,RoundedCornerShape(20.dp))
                    .border(1.dp,AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(12.dp,4.dp)
            ){
                Text(subject, fontSize = 12.sp, color = AppColors.textColorPrimary)
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(AppColors.orengeColor,RoundedCornerShape(20.dp))
                    .padding(12.dp,4.dp)
            ){
                Text(publish, fontSize = 12.sp, color = Color.White)
            }
        }
        Spacer(Modifier.height(5.dp))
        ExamDataCompose(Res.drawable.calendar,"Date",date)
        ExamDataCompose(Res.drawable.calendar,"Duration","$duration minutes")
        ExamDataCompose(Res.drawable.calendar,"Total Marks","$totalMarks")
        ExamDataCompose(Res.drawable.student,"Batch",batch)

        Spacer(Modifier.height(12.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier )

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier.fillMaxWidth().height(35.dp).weight(1f)
                    .background(AppColors.primaryColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    "Enter Marks",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth().height(35.dp).weight(1f)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
                Text12Primary("View Details")
            }
        }
        Spacer(Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(painterResource(Res.drawable.edit),"", tint = AppColors.textColorPrimary, modifier = Modifier.size(12.dp))
                Spacer(Modifier.width(5.dp))
                Text12Primary("Update")
            }
            Icon(painterResource(Res.drawable.delete),"", tint = Color.Red, modifier = Modifier.size(12.dp))
        }
    }
}

@Composable
fun AdminExamStateReusable(text: String, data: Int, icon: DrawableResource, color: Color,modifier: Modifier){
    Row(
        modifier = modifier
            .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column (
            modifier = Modifier.weight(1f)
        ){
            Text12Normal(text)
            Spacer(Modifier.height(5.dp))
            Text14SemiBold("$data")
        }
        Icon(
             painterResource(icon),
            "",
            tint = color,
            modifier = Modifier.size(15.dp)
        )
    }
}

@Composable
fun AdminExamReusableThing(type: String,data: String){
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = when(type){
                "Subject"->painterResource(Res.drawable.batch)
                "Time"->painterResource(Res.drawable.calendar)
                "Teacher"->painterResource(Res.drawable.student)
                else -> painterResource(Res.drawable.app_white_logo)
            },
            "",
            tint = AppColors.textColorSecondary,
            modifier = Modifier.size(12.dp)
        )
        Spacer(Modifier.width(5.dp))
        Text12Normal(data)
    }
}

@Composable
fun AdminUpcomingExamCard(title: String,date: String,duration: Int,totalMarks: Int,batch: String, testType: String, subject: String){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ){
        Text14SemiBold(title)
        Spacer(Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .background(AppColors.lightOrange,RoundedCornerShape(20.dp))
                    .padding(12.dp,4.dp)
            ){
                Text(testType, fontSize = 12.sp,  color = AppColors.orengeColor)
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(AppColors.cardBackground,RoundedCornerShape(20.dp))
                    .border(1.dp,AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(12.dp,4.dp)
            ){
                Text(subject, fontSize = 12.sp, color = AppColors.textColorPrimary)
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(AppColors.orengeColor,RoundedCornerShape(20.dp))
                    .padding(12.dp,4.dp)
            ){
                Text("Upcoming", fontSize = 12.sp, color = Color.White)
            }
        }
        Spacer(Modifier.height(5.dp))
        ExamDataCompose(Res.drawable.calendar,"Date",date)
        ExamDataCompose(Res.drawable.calendar,"Duration","$duration minutes")
        ExamDataCompose(Res.drawable.calendar,"Total Marks","$totalMarks")
        ExamDataCompose(Res.drawable.student,"Batch",batch)

        Spacer(Modifier.height(12.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier)

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(painterResource(Res.drawable.edit),"", tint = AppColors.textColorPrimary, modifier = Modifier.size(12.dp))
                Spacer(Modifier.width(5.dp))
                Text12Primary("Update")
            }
            Icon(painterResource(Res.drawable.delete),"", tint = Color.Red, modifier = Modifier.size(12.dp))
        }
    }
}

