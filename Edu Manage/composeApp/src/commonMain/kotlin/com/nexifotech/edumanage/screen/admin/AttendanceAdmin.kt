package com.nexifotech.edumanage.screen.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.util.trace
import com.nexifotech.edumanage.common.MyDatePicker
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.AttendanceStateModel
import com.nexifotech.edumanage.models.MarkAttendanceModel
import com.nexifotech.edumanage.theme.AppColors
import com.nexifotech.edumanage.theme.TextColorSecondary
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.logout
import edumanage.composeapp.generated.resources.person
import kotlinx.datetime.LocalDate
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdminAttendanceScreen(){

    var showPicker by remember { mutableStateOf(false) }
    var dateSelect by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf<String?>(null) }

    val list = listOf(
        MarkAttendanceModel("Rahul Kumar","001","Grade 10-A"),
        MarkAttendanceModel("Priya Sharma","002","Grade 10-A"),
        MarkAttendanceModel("Amit Patel","003","Grade 10-A"),
    )


    LazyColumn(
        modifier = Modifier.fillMaxSize().background(color = AppColors.background)
            .padding(14.dp, 0.dp, 14.dp, 2.dp)
    ) {

        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Attendance Management")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Today's attendance tracking - Completed & Pending")

            Spacer(modifier = Modifier.height(20.dp))

            /*Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.height(40.dp).weight(1f)
                        .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painterResource(Res.drawable.logout),
                        "",
                        tint = AppColors.textColorPrimary,
                        modifier = Modifier.size(15.dp)
                    )

                    Spacer(Modifier.width(5.dp))

                    Text14Normal("Export")
                }

                Spacer(Modifier.width(10.dp))

                Box(
                    modifier = Modifier.height(40.dp).weight(1f)
                        .background(AppColors.primaryColor, RoundedCornerShape(7.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Save Attendance", fontSize = 14.sp, color = Color.White
                    )
                }
            }
            Spacer(Modifier.height(14.dp))*/


        }

        item {


             Row(
                 modifier = Modifier.fillMaxWidth()
             ){
                 AttendanceAdminState(AttendanceStateModel("Completed Batches",2), modifier = Modifier.weight(1f))
                 Spacer(Modifier.width(10.dp))
                 AttendanceAdminState(AttendanceStateModel("Pending Batches",1), modifier = Modifier.weight(1f))
             }

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                AttendanceAdminState(AttendanceStateModel("Total Present",2), modifier = Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                AttendanceAdminState(AttendanceStateModel("Total Absent",1), modifier = Modifier.weight(1f))
            }

            Spacer(Modifier.height(14.dp))
        }

        item {

            Column(
                modifier = Modifier.fillMaxWidth()
                    .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp)).padding(16.dp)
            ) {
                Text14SemiBold("Date")
                Spacer(Modifier.height(10.dp))
                OutlinedTextField(
                    value = if (dateSelect) selected.toString() else "Select Date",
                    onValueChange = { it.toString() },
                    singleLine = true,
                    placeholder = { Text("Select Date", color = AppColors.textColorSecondary) },
                    textStyle = TextStyle(
                        color = AppColors.textColorPrimary, fontWeight = FontWeight.SemiBold
                    ),
                    trailingIcon = {
                        IconButton(onClick = {
                            showPicker = true
                        }) {
                            Icon(
                                painterResource(Res.drawable.calendar),
                                "",
                                tint = AppColors.textColorPrimary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AppColors.primaryColor,
                        unfocusedBorderColor = AppColors.borderColor
                    )
                )

            }

            Spacer(Modifier.height(20.dp))


            Text16Bold("Mark Attendance ( 3 Students )")

            Spacer(Modifier.height(14.dp))
        }

        items(list) {
            MarkAttendance(it)
        }

    }

    MyDatePicker(
            showPicker = showPicker,
            onDateSelected = { date ->
                selected = date },
            onDismiss = { showPicker = false },
            doneClick = {dateSelect = true}
        )

}

@Composable
fun AttendanceAdminState(attendanceStateModel: AttendanceStateModel, modifier: Modifier) {

    Column(
        modifier = modifier
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text12Normal(attendanceStateModel.text)

        Spacer(Modifier.height(5.dp))
        Text(
            "${attendanceStateModel.data}",
            color = when(attendanceStateModel.text){
                "Completed Batches"-> AppColors.greenColor
                "Pending Batches" -> AppColors.redColor
                "Total Present" -> AppColors.blueColor
                "Total Absent"-> AppColors.orengeColor
                else -> AppColors.textColorPrimary
            },
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun BatchDropdown(
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
fun MarkAttendance(
    it:  MarkAttendanceModel
){

    Column(modifier = Modifier.fillMaxWidth()
        .padding(0.dp,0.dp,0.dp,10.dp)
        .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
        .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
        .padding(16.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            // Profile Icon Placeholder
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(AppColors.background, RoundedCornerShape(50)),
                contentAlignment = Alignment.Center

            ){
                Icon(
                    painterResource(Res.drawable.person),
                    "",
                    tint = AppColors.textColorPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text14SemiBold(it.name)

                Row(){
                    Text12Normal("ID: ${it.id}")
                    Text12Normal(" | Batch: ${it.batch}")
                }

            }


        }

        Spacer(Modifier.height(10.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier )

        Spacer(Modifier.height(10.dp))

        // Buttons Row
         StudentPresence(
             onStateSelected = {}
         )
    }


}

@Composable
fun StudentPresence(onStateSelected: (String) -> Unit){
    var selectedState by remember { mutableStateOf("")}

    val state = listOf("Present","Absent","Late")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        state.forEach { currentState->
            val isSelected = currentState == selectedState

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(
                        if (isSelected){
                            when(currentState){
                                "Present"->AppColors.greenColor
                                "Absent"->AppColors.redColor
                                "Late"->AppColors.orengeColor
                                else -> AppColors.background
                            }
                        }else{
                            AppColors.background
                        }
                    )
                    .border(
                        1.dp,
                        if (isSelected) AppColors.cardBackground else AppColors.borderColor,
                        RoundedCornerShape(7.dp)
                    )
                    .clickable {
                        selectedState = currentState
                        onStateSelected(currentState) },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = currentState,
                    color = if (isSelected) Color.White else AppColors.textColorPrimary,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.width(8.dp))
        }
    }


}