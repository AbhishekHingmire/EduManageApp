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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.AddButton
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.AddTeacherModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.delete
import edumanage.composeapp.generated.resources.edit
import edumanage.composeapp.generated.resources.person
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdminFacultyScreen(){

    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColors.background)
            .padding(14.dp,20.dp,14.dp,2.dp)
    ){
       ScreenHeaderText("Teachers Management")

        Spacer(modifier = Modifier.height(5.dp))

        ScreenSubHeaderText("Manage all teachers records and assignments")


        // Add Teachers Button
        AddButton("Add Teacher", onClick = {})


        // Header: All Students (3)
        Text16Bold("All Teacher (2)")

        Spacer(Modifier.height(12.dp))

        SearchBoxAdminFaculty(
            value = search,
            placeholder = "Search teachers...",
            leadingIcon = Icons.Default.Search
        ){search=it}

        Spacer(Modifier.height(15.dp))

        val teachersList = listOf(

            AddTeacherModel("Rahul Sharma","ADM001",2,listOf(
                "Mathematics","Physics"
            )),
            AddTeacherModel("Ms. Sarah","EMP-2023-002",2,listOf(
                "Biology","Chemistry"
            ))
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(teachersList){teacher->
                AddTeacherCard(teacher)
            }
        }

    }
}

@Composable
fun AddTeacherCard(addTeacherModel: AddTeacherModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

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
                Text14SemiBold(addTeacherModel.name)

                Text12Normal(addTeacherModel.id)
            }

            // Active Label
            Box(
                modifier = Modifier
                    .background(AppColors.greenColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text("Active", color = Color.White, fontSize = 12.sp)
            }
        }

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text12Normal("Subjects")

                Spacer(Modifier.height(5.dp))

                LazyRow(){
                    items(addTeacherModel.subjects){
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
            }
            Spacer(Modifier.width(5.dp))
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.End
            ){
                Text12Normal("Batches")

                Spacer(Modifier.height(3.dp))

                Text12Primary("${addTeacherModel.batches}")
            }
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
                Text14Normal("View")
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


@Composable
fun SearchBoxAdminFaculty(
    value: String,
    placeholder: String,
    leadingIcon: ImageVector? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {Text(placeholder, color = AppColors.textColorSecondary)},
        textStyle = TextStyle(color = AppColors.textColorPrimary,
            fontWeight = FontWeight.SemiBold
        ),
        leadingIcon = { if (leadingIcon != null) Icon(leadingIcon, "", modifier = Modifier.size(24.dp), tint = AppColors.textColorSecondary) },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = AppColors.primaryColor,
            unfocusedBorderColor = AppColors.borderColor
        )
    )
}

