package com.nexifotech.edumanage.screen.teacher

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nexifotech.edumanage.common.Text16Bold

@Composable
fun TeacherPerformanceScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment =  Alignment.Center
    ){
        Text16Bold("Kaam chalu hai")
    }
}