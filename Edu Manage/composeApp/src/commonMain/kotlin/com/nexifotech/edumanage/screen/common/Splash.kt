package com.nexifotech.edumanage.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_logo
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SplashScreen(onFinish:()-> Unit){

    LaunchedEffect(true){
        delay(1500)
        onFinish()
    }

    Box(modifier = Modifier.fillMaxSize()
        .background(AppColors.background),
        contentAlignment = Alignment.Center,
        ){
        Image(
            painter = painterResource(Res.drawable.app_logo),
            contentDescription = "Splash Screen Logo",
            modifier = Modifier.size(120.dp)
        )
    }
}