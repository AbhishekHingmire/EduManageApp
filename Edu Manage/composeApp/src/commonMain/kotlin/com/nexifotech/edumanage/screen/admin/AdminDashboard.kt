package com.nexifotech.edumanage.screen.admin

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.theme.AppColors
import com.nexifotech.edumanage.theme.Green
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.attendance
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.exam
import edumanage.composeapp.generated.resources.rupee
import edumanage.composeapp.generated.resources.student
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AdminDashBoardScreen(){

    //Main Column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = AppColors.background)
            .padding(14.dp,20.dp)
    ){
        ScreenHeaderText("Admin Dashboard")

        Spacer(modifier = Modifier.height(5.dp))

        ScreenSubHeaderText("Welcome back! Here's your overview")

        Spacer(modifier = Modifier.height(14.dp))

        DashboardWarning("8 students with fees overdue>30 days", AppColors.redColor, AppColors.lightRed)
        Spacer(modifier = Modifier.height(7.dp))
        DashboardWarning("3 teachers haven't marked attendance", AppColors.orengeColor, AppColors.lightOrange)

        Spacer(modifier = Modifier.height(14.dp))

        //Dashboard data
        Column {
            Row (modifier = Modifier.fillMaxWidth()){
                DashBoardState("Total Students",
                    "250",
                    "+15 this month",
                    AppColors.blueColor,
                    AppColors.lightBlue,
                    Res.drawable.student,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                DashBoardState("Total Faculty",
                    "12",
                    "On leave: 1",
                    AppColors.greenColor,
                    AppColors.lightGreen,
                    Res.drawable.app_white_logo,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row (modifier = Modifier.fillMaxWidth()){
                DashBoardState("Today's Attendance",
                    "92%",
                    "230/250 present",
                    AppColors.orengeColor,
                    AppColors.lightOrange,
                    Res.drawable.attendance,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                DashBoardState("Fee Collection",
                    "$4.8L",
                    "64% collected",
                    AppColors.redColor,
                    AppColors.lightRed,
                    Res.drawable.rupee,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        //Quick action
        Column (modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(7.dp))
            .background(color = AppColors.cardBackground)
            .border(1.dp, color = AppColors.borderColor, shape = RoundedCornerShape(7.dp))
            .padding(16.dp)
        ){

            Text16Bold("Quick Action")

            Spacer(modifier = Modifier.height(10.dp))

            Row (modifier = Modifier.fillMaxWidth()){

                DashboardQuickAction(
                    text = "Add Student",
                    color = AppColors.blueColor,
                    image = Res.drawable.student,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                DashboardQuickAction(
                    text = "Mark Attendance",
                    color = AppColors.greenColor,
                    image = Res.drawable.attendance,
                    modifier = Modifier.weight(1f)
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            Row (modifier = Modifier.fillMaxWidth()){

                DashboardQuickAction(
                    text = "Manage Schedule",
                    color = AppColors.orengeColor,
                    image = Res.drawable.calendar,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))

                DashboardQuickAction(
                    text = "Generate Report",
                    color = AppColors.redColor,
                    image = Res.drawable.exam,
                    modifier = Modifier.weight(1f)
                )

            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        //Recent activity
        Column (
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(7.dp))
                .background(color = AppColors.cardBackground)
                .border(1.dp, color = AppColors.borderColor, shape = RoundedCornerShape(7.dp))
                .padding(16.dp)
        ){
            Text16Bold("Recent Activity")

            Spacer(modifier = Modifier.height(10.dp))

            DashboardRecentActivity(
                text = "Rahul Kumar enrolled in Grade 10 Math",
                time = "5 min ago",
                color = AppColors.blueColor,
                colorLight = AppColors.lightBlue,
                image = Res.drawable.student
            )

            DashboardRecentActivity(
                text = "₹3,000 payment received from Amit Sharma",
                time = "25 min ago",
                color = AppColors.greenColor,
                colorLight = AppColors.lightGreen,
                image = Res.drawable.rupee
            )

            DashboardRecentActivity(
                text = "Grade 8 attendance marked by Priya",
                time = "1 hour ago",
                color = AppColors.orengeColor,
                colorLight = AppColors.lightOrange,
                image = Res.drawable.attendance
            )

            DashboardRecentActivity(
                text = "Math assignment posted by Vikram",
                time = "2 hours ago",
                color = AppColors.textColorPrimary,
                colorLight = AppColors.textColorSecondary,
                image = Res.drawable.exam
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        //Pending task
        Column (
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(7.dp))
                .background(color = AppColors.cardBackground)
                .border(1.dp, color = AppColors.borderColor, shape = RoundedCornerShape(7.dp))
                .padding(16.dp)
        ){
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text16Bold("Pending Tasks")

                Spacer(Modifier.width(7.dp))

                Text(
                    text = "4",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(AppColors.greenColor)
                        .padding(7.dp,2.dp)
                )
            }
            Spacer(Modifier.width(14.dp))

            DashboardPendingTasks("3 leave requests pending approval")
            DashboardPendingTasks("2 student admissions need verification")
            DashboardPendingTasks("5 students with attendance <75%")
            DashboardPendingTasks("8 fee defaulters to follow up")
        }
    }


}

@Composable
fun DashBoardState(
    text : String,
    value : String,
    state : String,
    color : Color,
    colorLight : Color,
    image : DrawableResource,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier
        .clip(RoundedCornerShape(7.dp))
        .background(color = AppColors.cardBackground)
        .border(1.dp,AppColors.borderColor,RoundedCornerShape(7.dp))
        .padding(12.dp)
    ) {

        Column (
            modifier = Modifier.weight(1f)
        ){
            Text(
                text = text,
                color = AppColors.textColorSecondary,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = value,
                color = AppColors.textColorPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = state,
                color = Green,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(7.dp))
                .background(color = colorLight)
                .padding(5.dp,5.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(image),
                contentDescription = "",
                tint = color,
                modifier = Modifier.size(18.dp)
            )
        }
    }

}

@Composable
fun DashboardQuickAction(
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
            tint = Color(0xFFFFFFFF),
            modifier = Modifier.size(18.dp)
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color =  Color(0xFFFFFFFF),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun DashboardRecentActivity(
    text : String,
    time : String,
    color : Color,
    colorLight : Color,
    image : DrawableResource,
){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,7.dp)
    ){

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(color = colorLight)
                .padding(5.dp)
        ){
            Icon(
                painterResource(image),
                contentDescription = "",
                tint = color,
                modifier = Modifier.size(14.dp)
            )
        }

        Spacer(Modifier.width(10.dp))

        Column (
            modifier = Modifier.weight(1f)
        ){
            Text14Normal(text)

            Spacer(Modifier.height(3.dp))
            Text12Normal(time)
        }
    }
}

@Composable
fun DashboardPendingTasks(
    text: String,
    //onClick:()-> Unit
){
    Row(
        modifier = Modifier.padding(0.dp,7.dp)
    ){
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = AppColors.textColorPrimary,
            modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text = "View",
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = AppColors.textColorPrimary,

        )
    }
}

@Composable
fun DashboardWarning(
    text : String,
    color : Color,
    lightColor: Color
){
    Row(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(7.dp))
            .background(lightColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painterResource(Res.drawable.app_white_logo),
            contentDescription = "",
            tint = color,
            modifier = Modifier.size(18.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = AppColors.textColorPrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(7.dp))

        Box(
            modifier = Modifier.clip(RoundedCornerShape(7.dp))
                .background(color = AppColors.background)
                .border(1.dp, color = AppColors.borderColor,RoundedCornerShape(7.dp))
                .padding(10.dp,5.dp)
        ){
            Text(
                text = "Check",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = AppColors.textColorPrimary
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            painterResource(Res.drawable.calendar),
            contentDescription = "",
            tint = AppColors.textColorPrimary,
            modifier = Modifier.size(15.dp)
        )

    }
}