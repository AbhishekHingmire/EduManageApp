package com.nexifotech.edumanage.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res

@Composable
fun DropDown(
    list: List<String>,
    modifier: Modifier= Modifier,
    value: String,
    finalValue:(String)-> Unit
){
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Column (modifier){
        OutlinedTextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)
                .onGloballyPositioned{
                    textFieldSize = it.size.toSize()
                }
                .clickable(true,null,null,null, onClick = { expanded = !expanded }),
            trailingIcon = {
                Icon(
                    icon,
                    "",
                    Modifier.clickable{expanded = !expanded}
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
            )
        )
        DropdownMenu(
            expanded,
            onDismissRequest = {expanded=false},
            modifier = Modifier.width(with(LocalDensity.current){textFieldSize.width.toDp()})
                .background(AppColors.cardBackground)

        ){
            list.forEach {
                DropdownMenuItem(
                    text = { Text(it, color = AppColors.textColorPrimary) },
                    onClick = {
                        finalValue(it)
                        expanded=false
                    }
                )
            }
        }
    }
}