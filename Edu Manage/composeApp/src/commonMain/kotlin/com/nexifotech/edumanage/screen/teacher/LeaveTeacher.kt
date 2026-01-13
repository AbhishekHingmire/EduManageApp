package com.nexifotech.edumanage.screen.teacher

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nexifotech.edumanage.common.Text14SemiBold

@Composable
fun TeacherLeaveScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment =  Alignment.Center
    ){
        Text14SemiBold("Iss screen ko same as web nhi kar sakte to iske bare me thoda sochna hoga")
    }
}