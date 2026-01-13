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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.batch
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.student
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdminTimetableScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(color = AppColors.background)
            .padding(14.dp, 0.dp, 14.dp, 2.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Master Schedule")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("View and manage all class schedules")

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Text14Normal("Filter by Batch")
            Spacer(Modifier.height(5.dp))
            AdminBatchDropDown(
                listOf(
                    "All Batches",
                    "Grade 10-A",
                    "Grade 9-B",
                    "Grade 11-A"
                )
            )
            Spacer(Modifier.height(10.dp))
            Text14Normal("Filter by Day")
            Spacer(Modifier.height(5.dp))
            AdminFilterDays(
                listOf(
                    "All Days",
                    "Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday",
                    "Saturday",
                    "Sunday"
                )
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text16Bold("Weekly Timetable")
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                TimetableReusableThing2("15","Total Classes/Week", AppColors.blueColor, modifier = Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                TimetableReusableThing2("5","Active Teachers", AppColors.blueColor,modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(3.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                TimetableReusableThing2("3","Active Batches", AppColors.greenColor,modifier = Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                TimetableReusableThing2("6","Room in Use", AppColors.orengeColor,modifier = Modifier.weight(1f))
            }
        }
    }
}


@Composable
fun AdminBatchDropDown(
    batchList: List<String>,
    modifier: Modifier= Modifier
){
    var expended by remember { mutableStateOf(false)}
    var selectedBatch by remember { mutableStateOf("All Batches")}

    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expended) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Column (modifier){
        OutlinedTextField(
            value = selectedBatch,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)
                .onGloballyPositioned{
                    textFieldSize = it.size.toSize()
                }
                .clickable{expended=true},
            trailingIcon = {
                Icon(
                    icon,
                    contentDescription = null,
                    Modifier.clickable { expended = !expended }
                )
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AppColors.primaryColor,
                unfocusedBorderColor = AppColors.borderColor
            ),
            textStyle = TextStyle(
                color = AppColors.textColorPrimary,
                fontWeight = FontWeight.SemiBold
            ),

            )

        DropdownMenu(
            expended,
            onDismissRequest = {expended=false},
            modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})
                .background(AppColors.cardBackground)
        ){
            batchList.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item, color = AppColors.textColorPrimary) },
                    onClick = {
                        selectedBatch = item
                        expended = false
                    }
                )
            }
        }
    }
}


@Composable
fun AdminFilterDays(
    daysList: List<String>,
    modifier: Modifier= Modifier
){
    var expended by remember { mutableStateOf(false)}
    var selectedBatch by remember { mutableStateOf("All Days")}

    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expended) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Column (modifier){
        OutlinedTextField(
            value = selectedBatch,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)
                .onGloballyPositioned{
                    textFieldSize = it.size.toSize()
                }
                .clickable{expended=true},
            trailingIcon = {
                Icon(
                    icon,
                    contentDescription = null,
                    Modifier.clickable { expended = !expended }
                )
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AppColors.primaryColor,
                unfocusedBorderColor = AppColors.borderColor
            ),
            textStyle = TextStyle(
                color = AppColors.textColorPrimary,
                fontWeight = FontWeight.SemiBold
            ),
            )

        DropdownMenu(
            expended,
            onDismissRequest = {expended=false},
            modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})
                .background(AppColors.cardBackground)
        ){
            daysList.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item, color = AppColors.textColorPrimary) },
                    onClick = {
                        selectedBatch = item
                        expended = false
                    }
                )
            }
        }
    }
}

@Composable
fun AdminTimetableCard(){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text14SemiBold("Grade 10-A")
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .background(AppColors.cardBackground,RoundedCornerShape(20.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(12.dp,4.dp)
            ){
                Text12Primary("Room 201")
            }
        }

        Spacer(Modifier.height(10.dp))
        TimetableReuseableThing("Subject","Mathematics")
        Spacer(Modifier.height(5.dp))
        TimetableReuseableThing("Time","09:00 AM - 10:00 AM")
        Spacer(Modifier.height(5.dp))
        TimetableReuseableThing("Teacher","Dr. John Smith")

    }
}

@Composable
fun TimetableReuseableThing(
    type: String,
    text: String
){
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
        Text12Normal(text)
    }
}

@Composable
fun TimetableReusableThing2(data: String,text: String,color: Color,modifier: Modifier){
    Column(
        modifier = modifier
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            data,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = color
        )
        Spacer(Modifier.height(5.dp))
        Text12Normal(text)
    }
}