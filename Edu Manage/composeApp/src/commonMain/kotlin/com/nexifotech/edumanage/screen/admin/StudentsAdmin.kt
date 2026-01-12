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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.nexifotech.edumanage.common.AddButton
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.AddStudentModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.delete
import edumanage.composeapp.generated.resources.edit
import edumanage.composeapp.generated.resources.person
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AdminStudentScreen() {

    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppColors.background)
            .padding(14.dp, 20.dp, 14.dp, 2.dp)
    ) {
        ScreenHeaderText("Students Management")

        Spacer(modifier = Modifier.height(5.dp))

        ScreenSubHeaderText("Manage all student records and information")

        // Add Student Button
        AddButton("Add Student", onClick = {})


        // Header: All Students (3)
        Text16Bold("All Students (3)")

        Spacer(Modifier.height(12.dp))

        BatchDropDown(
            batchList = listOf(
                "All Batches",
                "Grade 10 - Mathematics",
                "Grade 9 - Science",
                "Grade 11 - Physics"
            )
        )

        Spacer(Modifier.height(5.dp))
        // Search Box
        SearchBox(
            value = search,
            placeholder = "Search Students...",
            leadingIcon = Icons.Default.Search,

            ) { search = it }

        Spacer(Modifier.height(15.dp))

        val studentList = listOf(
            AddStudentModel("Rahul Sharma", "ADM001", "Grade 10-A", "85%"),
            AddStudentModel("Priya Patel", "ADM002", "Grade 10-A", "92%"),
            AddStudentModel("Amit Kumar", "ADM003", "Grade 11-B", "78%")
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(studentList) { student ->
                AddStudentCard(student)
            }
        }
    }
}

@Composable
fun AddStudentCard(studentModel: AddStudentModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            // Profile Icon Placeholder
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(AppColors.background, RoundedCornerShape(50)),
                contentAlignment = Alignment.Center

            ){
                Icon(
                    painterResource(Res.drawable.person),
                    "",
                    tint = AppColors.textColorPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text14SemiBold(studentModel.name)

                Text12Normal(studentModel.id)
            }

            // Active Label
            Box(
                modifier = Modifier
                    .background(AppColors.greenColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text("Active", color = Color.White, fontSize = 12.sp)
            }
        }

        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text12Normal("Batch:")
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .background(AppColors.background, RoundedCornerShape(20.dp))
                    .border(1.dp, AppColors.borderColor, RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text12Primary(studentModel.grade)
            }
        }

        Spacer(Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text12Normal("Attendance:")
            Spacer(Modifier.weight(1f))
            Text14SemiBold(studentModel.attendance)
        }



        Spacer(Modifier.height(10.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier)

        Spacer(Modifier.height(10.dp))

        // Buttons Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // View Button
            Box(
                modifier = Modifier.fillMaxWidth().height(40.dp).weight(1f)
                    .background(AppColors.background, RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text14Normal("View")
            }
            Spacer(Modifier.width(7.dp))
            Row {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(AppColors.background, RoundedCornerShape(7.dp))
                        .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painterResource(Res.drawable.edit),
                        "",
                        tint = AppColors.textColorPrimary,
                        modifier = Modifier.size(15.dp)
                    )
                }
                Spacer(Modifier.width(7.dp))

                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(AppColors.background, RoundedCornerShape(7.dp))
                        .border(1.dp, AppColors.borderColor, RoundedCornerShape(7.dp))
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
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

@Composable
fun SearchBox(
    value: String,
    placeholder: String,
    leadingIcon: ImageVector? = null,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
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
fun BatchDropDown(
    batchList: List<String>,
    modifier: Modifier = Modifier
) {
    var expended by remember { mutableStateOf(false) }
    var selectedBatch by remember { mutableStateOf("All Batches") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expended) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Column(modifier) {
        OutlinedTextField(
            value = selectedBatch,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)
                .onGloballyPositioned {
                    textFieldSize = it.size.toSize()
                }
                .clickable { expended = true },
            trailingIcon = {
                Icon(
                    icon,
                    "",
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
            onDismissRequest = { expended = false },
            modifier = Modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .background(AppColors.cardBackground)
        ) {
            batchList.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item, color = AppColors.textColorPrimary) },
                    onClick = {
                        selectedBatch = item
                        expended = false
                    }
                )
            }
        }
    }
}
