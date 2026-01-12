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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import com.nexifotech.edumanage.common.AddButton
import com.nexifotech.edumanage.common.DropDown
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.TeacherStudyMaterial
import com.nexifotech.edumanage.screen.admin.SearchBox
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.delete
import edumanage.composeapp.generated.resources.edit
import edumanage.composeapp.generated.resources.exam
import edumanage.composeapp.generated.resources.eye
import edumanage.composeapp.generated.resources.logout
import edumanage.composeapp.generated.resources.report
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun TeacherStudyMaterialScreen(){

    val materialList = listOf(
        TeacherStudyMaterial("Quadratic Equations - Complete Notes","Mathematics","Chapter 4",listOf("Grade 10 - A","Grade 10 - B")),
        TeacherStudyMaterial("Newton's Laws of Motion Video","Physics","Chapter 5",listOf("Grade 11 - A"))
    )

    var month by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var search by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(AppColors.background)
            .padding(14.dp,0.dp)
    ){
        //Header
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Study Materials")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Upload and manage learning resources")

            AddButton("Upload Material",{

            })

        }

        //data
        item{
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                StudyMaterialData("Total Materials","430", Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                StudyMaterialData("Total Views","65684", Modifier.weight(1f))
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                StudyMaterialData("Downloads","40072", Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                StudyMaterialData("This Month","430", Modifier.weight(1f))
            }

            Spacer(Modifier.height(10.dp))

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
            Text14Normal("Type")
            Spacer(modifier = Modifier.height(5.dp))
            DropDown(
                list = listOf(
                    "All Types",
                    "PDF",
                    "Video",
                    "Link",
                    "PPT",
                    "Document"
                ),
                modifier = Modifier,
                value = type,
                finalValue = {
                    type=it
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
            Text16Bold("My Uploaded Materials")
            Spacer(Modifier.height(10.dp))
        }

        items(materialList){
            TeacherStudyMaterialCard(it)
        }


    }
}

@Composable
fun TeacherStudyMaterialCard(model: TeacherStudyMaterial ){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,7.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(AppColors.lightBlue,RoundedCornerShape(7.dp)),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(Res.drawable.exam),
                    "",
                    tint = AppColors.blueColor,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(Modifier.width(10.dp))

            Column(

            ){
                Text14SemiBold(model.materialTitle)
                Spacer(Modifier.height(2.dp))
                Text12Normal("${model.subject} | ${model.topic}")
            }
        }
        Spacer(Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ){
            items(model.batch){
                Box(
                    modifier = Modifier
                        .padding(0.dp,0.dp,10.dp,0.dp)
                        .background(AppColors.background, RoundedCornerShape(20.dp))
                        .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text12Primary(it)
                }
            }
        }
        Spacer(Modifier.height(10.dp))

        Row(

        ){
            Spacer(Modifier.weight(1f))
            Icon(
                painterResource(Res.drawable.eye),
                "",
                tint = AppColors.textColorPrimary,
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(14.dp))
            Icon(
                painterResource(Res.drawable.edit),
                "",
                tint = AppColors.textColorPrimary,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(14.dp))
            Icon(
                painterResource(Res.drawable.delete),
                "",
                tint = AppColors.redColor,
                modifier = Modifier.size(17.dp)
            )
        }
    }
}

@Composable
fun StudyMaterialData(title: String,data: String,modifier: Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(AppColors.cardBackground, RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier.weight(1f)
        ){
            Text12Normal(title)
            Spacer(Modifier.height(5.dp))
            Text16Bold(data)
        }
        Icon(painterResource(when(title){
            "Total Materials"->Res.drawable.exam
            "Total Views"->Res.drawable.eye
            "Downloads"->Res.drawable.logout
            "This Month"->Res.drawable.report
            else -> Res.drawable.app_white_logo
        }),
            "",
            tint = when(title){
                "Total Materials"->AppColors.primaryColor
                "Total Views"->AppColors.greenColor
                "Downloads"->AppColors.redColor
                "This Month"->AppColors.orengeColor
                else -> AppColors.textColorPrimary
            },
            modifier = Modifier.size(20.dp)
        )
    }
}

