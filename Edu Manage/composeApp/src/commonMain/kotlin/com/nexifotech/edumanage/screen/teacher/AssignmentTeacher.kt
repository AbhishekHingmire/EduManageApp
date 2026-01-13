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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import com.nexifotech.edumanage.models.CreateAssignmentModel
import com.nexifotech.edumanage.screen.admin.SearchBox
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.delete
import edumanage.composeapp.generated.resources.edit
import edumanage.composeapp.generated.resources.exam
import edumanage.composeapp.generated.resources.eye
import org.jetbrains.compose.resources.painterResource


@Composable
fun TeacherAssignmentScreen(){

    val assignmentList = listOf(
        CreateAssignmentModel("Quadratic Equations - Problem Set","Mathematics","Active","Solve the given set of quadratic and show all working.","June 20th, 2025, 11:59 PM",50)
    )

    var month by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var search by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(AppColors.background)
            .padding(14.dp,0.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Assignment")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Create and manage homework assignment")

            AddButton("Create Assignment",{

            })

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
            Text14Normal("Subjects")
            Spacer(modifier = Modifier.height(5.dp))
            DropDown(
                list = listOf(
                    "All Subjects",
                    "APhysics",
                    "Math",
                    "Biology"
                ),
                modifier = Modifier,
                value = subject,
                finalValue = {
                    subject=it
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text14Normal("Status")
            Spacer(modifier = Modifier.height(5.dp))
            DropDown(
                list = listOf(
                    "All Status",
                    "Active",
                    "Draft",
                    "Closed"
                ),
                modifier = Modifier,
                value = status,
                finalValue = {
                    status=it
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text14Normal("Search")
            Spacer(modifier = Modifier.height(5.dp))
            SearchBox(
                value = search,
                placeholder = "Search Assignment...",
                leadingIcon = Icons.Default.Search
            ){
                search=it
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        items(assignmentList){
            CreateAssignmentCard(it)
            CreateAssignmentCard(it)
            CreateAssignmentCard(it)
            CreateAssignmentCard(it)
        }
    }
}

@Composable
fun CreateAssignmentCard(model: CreateAssignmentModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10 .dp)
            .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Text14SemiBold(model.title)
        Spacer(Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .background(AppColors.background, RoundedCornerShape(20.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text12Primary(model.subject)
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(AppColors.greenColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(model.status, fontSize = 12.sp,color = Color.White)
            }
        }
        Spacer(Modifier.height(10.dp))

        Text12Normal(model.description)

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

            Text12Normal("Due: ")
            Text12Primary(model.date)
        }

        Spacer(Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painterResource(Res.drawable.exam),
                "",
                tint = AppColors.textColorSecondary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(5.dp))

            Text12Normal("Total Marks: ")
            Text12Primary(model.totalMarks.toString())
        }


        Spacer(Modifier.height(10.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier )

        Spacer(Modifier.height(10.dp))

        // Buttons Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // View Button
            Box(
                modifier = Modifier.fillMaxWidth().height(40.dp).weight(1f)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
                Text14Normal("View Submission")
            }
            Spacer(Modifier.width(7.dp))
            Row {
                Box(modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painterResource(Res.drawable.eye),
                        "",
                        tint = AppColors.textColorPrimary,
                        modifier = Modifier.size(15.dp)
                    )
                }
                Spacer(Modifier.width(7.dp))

                Box(modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painterResource(Res.drawable.edit),
                        "",
                        tint = AppColors.textColorPrimary,
                        modifier = Modifier.size(15.dp)
                    )
                }
                Spacer(Modifier.width(7.dp))

                Box(modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painterResource(Res.drawable.delete),
                        "",
                        tint = AppColors.redColor,
                        modifier = Modifier.size(15.dp)
                    )
                }

            }
        }
    }
}