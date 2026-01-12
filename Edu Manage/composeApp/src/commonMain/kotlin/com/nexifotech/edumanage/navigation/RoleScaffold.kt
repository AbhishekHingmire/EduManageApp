package com.nexifotech.edumanage.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.RoleManageCache
import com.nexifotech.edumanage.models.DrawerModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.app_logo
import edumanage.composeapp.generated.resources.app_white_logo
import edumanage.composeapp.generated.resources.attendance
import edumanage.composeapp.generated.resources.batch
import edumanage.composeapp.generated.resources.calendar
import edumanage.composeapp.generated.resources.dashboard
import edumanage.composeapp.generated.resources.exam
import edumanage.composeapp.generated.resources.logout
import edumanage.composeapp.generated.resources.person
import edumanage.composeapp.generated.resources.report
import edumanage.composeapp.generated.resources.student
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun RoleScaffold(
    role: String,
    selectedItem: String,
    onItemClick:(DrawerModel) -> Unit,
    content: @Composable () -> Unit
){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val items = when (role) {
        "Student" -> listOf(
            DrawerModel("Dashboard", Res.drawable.dashboard),
            DrawerModel("Timetable", Res.drawable.calendar),
            DrawerModel("Assignments", Res.drawable.exam),
            DrawerModel("Exams", Res.drawable.exam),
            DrawerModel("Study Material", Res.drawable.exam),
            DrawerModel("Doubts", Res.drawable.app_white_logo),
            DrawerModel("Attendance", Res.drawable.attendance)
        )
        "Teacher" -> listOf(
            DrawerModel("Dashboard", Res.drawable.dashboard),
            DrawerModel("Timetable", Res.drawable.calendar),
            DrawerModel("Exams", Res.drawable.exam),
            DrawerModel("Attendance", Res.drawable.attendance),
            DrawerModel("Study Material", Res.drawable.exam),
            DrawerModel("Assignments", Res.drawable.exam),
            DrawerModel("Leave", Res.drawable.app_white_logo),
            DrawerModel("Performance", Res.drawable.report)
        )
        "Admin" -> listOf(
            DrawerModel("Dashboard", Res.drawable.dashboard),
            DrawerModel("Students", Res.drawable.student),
            DrawerModel("Faculty", Res.drawable.app_white_logo),
            DrawerModel("Batches", Res.drawable.batch),
            DrawerModel("Timetable", Res.drawable.calendar),
            DrawerModel("Attendance", Res.drawable.attendance),
            DrawerModel("Study Material", Res.drawable.exam),
            DrawerModel("Exams", Res.drawable.exam),
            DrawerModel("Assignment", Res.drawable.exam),
            DrawerModel("Finance", Res.drawable.app_white_logo),
            DrawerModel("Report", Res.drawable.report)
        )
        else -> emptyList()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = AppColors.background,
                modifier = Modifier.width(320.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().background(AppColors.background)
                        .padding(15.dp, 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(Res.drawable.app_logo),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Gopal Poddar Coaching Center",
                        color = AppColors.textColorPrimary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(color = AppColors.textColorSecondary)

                Text(
                    text = "Menu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = AppColors.textColorSecondary,
                    modifier = Modifier.padding(30.dp,10.dp)
                )

                items
                    .forEach {items->
                        NavigationDrawerItem(
                             label = {
                                 Row (
                                     modifier = Modifier
                                         .fillMaxWidth()
                                         .clip(RoundedCornerShape(14.dp))
                                         .padding(5.dp,0.dp),
                                     verticalAlignment = Alignment.CenterVertically
                                 ){
                                     Icon(
                                         painter = painterResource(items.icon),
                                         contentDescription = items.title,
                                         modifier = Modifier.size(20.dp)
                                     )
                                     Spacer(modifier = Modifier.width(12.dp))
                                     Text(items.title, fontWeight = FontWeight.SemiBold)
                                 }
                             },
                            selected = selectedItem == items.title,
                            onClick = {
                                onItemClick(items)
                                scope.launch { drawerState.close() }

                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = AppColors.lightBlue,   // Selected item rectangle background
                                unselectedContainerColor = Color.Transparent, // Unselected bg
                                selectedIconColor = AppColors.primaryColor,        // Selected icon color
                                unselectedIconColor = AppColors.textColorPrimary,      // Unselected icon
                                selectedTextColor = AppColors.primaryColor,              // Selected text
                                unselectedTextColor = AppColors.textColorPrimary       // Unselected text
                            ),
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 0.dp)
                                .clip(RoundedCornerShape(10.dp))

                        )
                    }

                Divider(color = AppColors.textColorSecondary)
                NavigationDrawerItem(
                    label = {
                        Row ( modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .padding(5.dp,0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                painter = painterResource(Res.drawable.logout),
                                contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text("Logout",fontWeight = FontWeight.SemiBold)
                        }
                    },
                    selected = false,
                    onClick = {
                        RoleManageCache.clearRole()
                        onItemClick(DrawerModel("Logout", Res.drawable.logout))
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = AppColors.lightBlue,   // Selected item rectangle background
                        unselectedContainerColor = Color.Transparent, // Unselected bg
                        selectedIconColor = AppColors.primaryColor,        // Selected icon color
                        unselectedIconColor = AppColors.redColor,      // Unselected icon
                        selectedTextColor = AppColors.primaryColor,              // Selected text
                        unselectedTextColor = AppColors.redColor       // Unselected text
                    ),
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 0.dp)
                        .clip(RoundedCornerShape(10.dp))
                )


            }
        }
    ){
        Scaffold(
            topBar = {
                Column (modifier = Modifier.background(color = AppColors.background)){
                    TopAppBar(
                        title = { Text(selectedItem,
                            fontSize =  16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = AppColors.textColorPrimary
                        ) },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch { drawerState.open() }
                            }) {
                                Icon(Icons.Default.Menu, "menu", tint = AppColors.textColorPrimary)
                            }
                        },
                        actions = {
                            // Profile avatar
                            Box(
                                modifier = Modifier
                                    .padding(end = 15.dp)
                                    .size(32.dp)
                                    .clip(RoundedCornerShape(50))
                                    .background(AppColors.lightBlue)
                                    .clickable(true, onClick = {})
                                ,
                                contentAlignment = Alignment.Center,
                            ) {
                                Icon(
                                    painter = painterResource(Res.drawable.person),
                                    contentDescription = "",
                                    tint = AppColors.textColorPrimary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = AppColors.background
                        )
                    )
                    Divider(color = AppColors.borderColor)
                }
            }
        ){ padding ->
           Box(Modifier.padding(padding)){
               content()
           }
        }
    }
}