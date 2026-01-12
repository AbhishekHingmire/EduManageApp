package com.nexifotech.edumanage.screen.common

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AppBarColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_logo
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.eye
import edumanage.composeapp.generated.resources.lock
import edumanage.composeapp.generated.resources.person
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun LoginScreen(onLogin:(String)-> Unit, onSignupClick:()->Unit){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf("Admin") }

    Box(modifier = Modifier.fillMaxSize()
        .background(AppColors.background),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier.fillMaxWidth()
            .padding(16.dp,0.dp)
            .clip(RoundedCornerShape(3))
            .background(AppColors.cardBackground)
            .border(1.dp,AppColors.borderColor,RoundedCornerShape(3))
            .padding(18.dp,30.dp)
            .clip(RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(50))   // pehle clip lagao
                    .background(AppColors.primaryColor),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.app_white_logo),
                    contentDescription = "Splash Screen Logo",
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "EduManage",
                color = AppColors.textColorPrimary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Tuition Management System",
                color = AppColors.textColorSecondary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Email",
                color = AppColors.textColorPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth().padding(3.dp,0.dp)

            )

            Spacer(modifier = Modifier.height(8.dp))

            LoginTextField(
                value = email,
                placeholder = "Enter email",
                leadingIcon = painterResource(Res.drawable.person)
            ){email=it}

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Password",
                color = AppColors.textColorPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth().padding(3.dp,0.dp)

            )

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                value = password,
                placeholder = "Enter password",
                leadingIcon = painterResource(Res.drawable.lock),
                trailingIcon = painterResource(Res.drawable.eye)

            ){password=it}

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Select Role",
                color = AppColors.textColorPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth().padding(3.dp,0.dp)

            )

            Spacer(modifier = Modifier.height(8.dp))

             RoleSelector(
                 selectedRole = selectedRole,
                 onRoleSelected = { selectedRole = it }
             )

            Spacer(Modifier.height(30.dp))

            Button(
                onClick = {
                    onLogin(selectedRole)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.primaryColor,
                    contentColor = Color.White
                )

            ){
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold)

            }

            Spacer(Modifier.height(20.dp))

            Text(
                "Forgot password?",
                color = AppColors.primaryColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun RoleSelector(selectedRole: String, onRoleSelected: (String) -> Unit) {

    val roles = listOf("Admin", "Teacher", "Student")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        roles.forEach { role ->

            val isSelected = role == selectedRole

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (isSelected) AppColors.primaryColor else AppColors.background)
                    .border(
                        1.dp,
                        if (isSelected) AppColors.cardBackground else AppColors.borderColor,
                        RoundedCornerShape(10.dp)
                    )
                    .clickable { onRoleSelected(role) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = role,
                    color = if (isSelected) Color.White else AppColors.textColorPrimary,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.width(8.dp))
        }
    }
}

@Composable
fun PasswordTextField(
    value: String,
    placeholder: String,
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    onValueChange: (String) -> Unit
) {

    var isVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = AppColors.textColorSecondary) },
        textStyle = TextStyle(
            color = AppColors.textColorPrimary,
            fontWeight = FontWeight.SemiBold
        ),
        leadingIcon = {
            if (leadingIcon != null) Icon(
                leadingIcon,
                "",
                modifier = Modifier.size(24.dp),
                tint = AppColors.textColorSecondary
            )
        },
        trailingIcon = {
            if (trailingIcon != null)
                IconButton(onClick = { isVisible = !isVisible }) {
                    Icon(trailingIcon, "",modifier = Modifier.size(20.dp),tint = AppColors.textColorSecondary)
                }
        },
        singleLine = true,
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
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


@Composable
fun LoginTextField(
    value: String,
    placeholder: String,
    leadingIcon: Painter? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = { Text(placeholder,color = AppColors.textColorSecondary) },
        textStyle = TextStyle(
            color = AppColors.textColorPrimary,
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

