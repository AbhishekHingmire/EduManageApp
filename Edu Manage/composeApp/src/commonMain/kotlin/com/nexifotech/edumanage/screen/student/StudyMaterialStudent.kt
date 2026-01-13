package com.nexifotech.edumanage.screen.student

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SettingsInputAntenna
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.screen.admin.SearchBox
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.exam
import org.jetbrains.compose.resources.painterResource

@Composable
fun StudentStudyMaterialScreen(){

    var search by remember{ mutableStateOf("") }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(AppColors.background)
            .padding(14.dp,0.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))

            ScreenHeaderText("Study Materials")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Access notes, videos, and practice materials")

            Spacer(modifier = Modifier.height(20.dp))

            SearchBox(
                value = search,
                placeholder = "Search Materials by title, chapter, or tags...",
                leadingIcon = Icons.Default.Search
            ){search=it}

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                DropDownOptions(listOf("All Subjects","Mathematics","Physics"),"All Subjects", modifier = Modifier.weight(1f))
                Spacer(Modifier.width(10.dp))
                DropDownOptions(listOf("All Types","PDF","VIDEO","NOTES"),"All Types",modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(14.dp))
            StudentStudyMaterialCard("Quadratic Equations - Complete Guide","Mathematics","PDF")
            StudentStudyMaterialCard("Newton's Laws Explained","Physics","VIDEO")
        }
    }
}


@Composable
fun DropDownOptions(
    list: List<String>,
    name: String,
    modifier: Modifier= Modifier
){
    var expended by remember { mutableStateOf(false)}
    var selected by remember { mutableStateOf(name)}

    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expended) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Column (modifier){
        OutlinedTextField(
            value = selected,
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
            list.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item, color = AppColors.textColorPrimary) },
                    onClick = {
                        selected = item
                        expended = false
                    }
                )
            }
        }
    }
}

@Composable
fun StudentStudyMaterialCard(title: String,subject: String,type: String){
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
            when(type){
                "PDF"->{
                    Icon(
                        painterResource(Res.drawable.exam),
                        "",
                        tint = AppColors.blueColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
                "NOTES"->{
                    Icon(
                        painterResource(Res.drawable.exam),
                        "",
                        tint = AppColors.blueColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
                "VIDEO"->{
                    Icon(
                        painterResource(Res.drawable.app_white_logo),
                        "",
                        tint = AppColors.blueColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            Spacer(Modifier.width(10.dp))
            Text(title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = AppColors.textColorPrimary, modifier = Modifier.weight(1f))
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .background(AppColors.greenColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(type, color = Color.White, fontSize = 12.sp)
            }

        }
        Spacer(Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .background(AppColors.cardBackground, RoundedCornerShape(20.dp))
                .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text12Primary(subject)
        }
        Spacer(Modifier.height(10.dp))
        Box(
            modifier = Modifier.fillMaxWidth()
                .background(AppColors.background,RoundedCornerShape(7.dp))
                .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                .padding(0.dp,10.dp),
            contentAlignment = Alignment.Center
        ){
            Text14Normal("View")
        }
    }
}