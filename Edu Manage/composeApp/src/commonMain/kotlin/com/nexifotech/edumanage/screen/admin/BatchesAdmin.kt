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
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.models.CreateBatchModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.delete
import edumanage.composeapp.generated.resources.edit
import edumanage.composeapp.generated.resources.student
import kotlinx.coroutines.sync.Mutex
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdminBatchesScreen(){

    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColors.background)
            .padding(14.dp,20.dp,14.dp,2.dp)
    ){
        ScreenHeaderText("Batch Management")

        Spacer(modifier = Modifier.height(5.dp))

        ScreenSubHeaderText("Create and manage class batches")

        AddButton("Create Batch",{

        })


        val batchList = listOf(
            CreateBatchModel("Grade 10 - Mathematics","Dr. John Smith",25,30,listOf("Mathematics")),
            CreateBatchModel("Grade 9 - Science","Mr. Sarah Johnson",28,30,listOf("Biology","Chemistry")),
            CreateBatchModel("Grade 11 - Physics","Dr. John Smith",20,25,listOf("Physics")),
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ){
            items(batchList){batch->
                CreateBatchCard(batch)
            }
        }
    }
}

@Composable
fun CreateBatchCard(createBatchModel: CreateBatchModel){
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
        ){
            Text(
                createBatchModel.batchName,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.textColorPrimary,
                modifier = Modifier.weight(1f)
            )

            // Ongoing Label
            Box(
                modifier = Modifier
                    .background(AppColors.greenColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text("Ongoing", color = Color.White, fontSize = 12.sp)
            }
        }

        Spacer(Modifier.height(5.dp))

        LazyRow(){
            items(createBatchModel.subjects){
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

        Row(){
            Icon(
                painter = painterResource(Res.drawable.student),
                "",
                tint = AppColors.textColorPrimary,
                modifier = Modifier.size(15.dp)
            )

            Spacer(Modifier.width(5.dp))

            Text12Primary(createBatchModel.batchTeacher)
        }

        Spacer(Modifier.height(5.dp))

        Row(){
            Icon(
                painter = painterResource(Res.drawable.student),
                "",
                tint = AppColors.textColorPrimary,
                modifier = Modifier.size(15.dp)
            )

            Spacer(Modifier.width(5.dp))

           Text12Primary("${createBatchModel.studentsCount}/${createBatchModel.batchCapacity} Students")
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
