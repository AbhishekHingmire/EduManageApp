package com.nexifotech.edumanage.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.nexifotech.edumanage.theme.AppColors
import kotlinx.datetime.LocalDate
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelDatePickerView
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView
import network.chaintech.kmp_date_time_picker.utils.now

@Composable
fun MyDatePicker(
    showPicker: Boolean,
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit,
    doneClick:()-> Unit
){

    if (showPicker) {
        Dialog(onDismissRequest = { onDismiss() }
        ) {
            WheelDatePickerView(
                showDatePicker = showPicker,
                height = 250.dp,
                dateTimePickerView = DateTimePickerView.DIALOG_VIEW,
                rowCount = 5,
                doneLabelStyle = TextStyle(
                    color = AppColors.primaryColor
                ),
                selectedDateTextStyle = TextStyle(color = AppColors.textColorPrimary),
                defaultDateTextStyle = TextStyle(color = AppColors.textColorPrimary),
                containerColor = AppColors.cardBackground,
                onDoneClick = {
                    onDateSelected(it.toString())
                    onDismiss()
                    doneClick()
                },
                onDismiss = {

                    onDismiss()
                }   ,
                modifier = Modifier.background(AppColors.background,RoundedCornerShape(12.dp))
                    .padding(16.dp)
            )
        }
    }


}