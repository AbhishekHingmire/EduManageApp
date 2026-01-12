package com.nexifotech.edumanage.screen.student

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
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.screen.admin.SearchBox
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun StudentDoubtScreen(){

    var search by remember{ mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(AppColors.background)
            .padding(14.dp,0.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Doubt Clearing")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Ask questions and get answers")

            AddButton("Ask Doubt"){

            }

            SearchBox(
                value = search,
                placeholder = "Search doubts by questions, description...",
                leadingIcon = Icons.Default.Search
            ){search=it}

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                DropDownOptions(listOf("All Subjects","Mathematics","Physics"),"All Subjects", modifier = Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                DropDownOptions(listOf("All Status","Answered","Pending" ),"All Status",modifier = Modifier.weight(1f))
            }

            Spacer(Modifier.height(14.dp))
            StudentDoubtCard("How to solve complex quaratic equations?","Answered","Mathematics","5/18/2025",3,5)
            StudentDoubtCard("How to solve complex chapter 5 equations?","Pending","Mathematics","5/18/2025",3,5)
        }
    }
}

@Composable
fun StudentDoubtCard(title: String,status: String,subject: String,date: String,likeCount: Int,totalAns: Int){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp, 0.dp,10.dp)
            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = AppColors.textColorPrimary,
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .background(color = when(status){
                        "Answered"->{
                            AppColors.greenColor}
                        "Pending"->{
                            AppColors.redColor}
                        else -> {
                            AppColors.cardBackground}
                    }, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(status, color = Color.White, fontSize = 12.sp)
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .background(AppColors.cardBackground, RoundedCornerShape(20.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text12Primary(subject)
            }
            Spacer(Modifier.width(10.dp))
            Text12Normal(date)
        }
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painterResource(Res.drawable.app_white_logo),
                "",
                tint = AppColors.textColorPrimary,
                modifier = Modifier.size(15.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text12Primary("$likeCount")
            Spacer(Modifier.width(15.dp))
            Text12Normal("$totalAns answers")

            Spacer(Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .background(AppColors.background, RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
                Text12Primary("View Details")
            }
        }
    }
}