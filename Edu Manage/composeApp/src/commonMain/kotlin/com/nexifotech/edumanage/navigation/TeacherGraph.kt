package com.nexifotech.edumanage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nexifotech.edumanage.screen.admin.AdminAttendanceScreen
import com.nexifotech.edumanage.screen.teacher.TeacherAssignmentScreen
import com.nexifotech.edumanage.screen.teacher.TeacherDashboardScreen
import com.nexifotech.edumanage.screen.teacher.TeacherExamScreen
import com.nexifotech.edumanage.screen.teacher.TeacherLeaveScreen
import com.nexifotech.edumanage.screen.teacher.TeacherPerformanceScreen
import com.nexifotech.edumanage.screen.teacher.TeacherStudyMaterialScreen
import com.nexifotech.edumanage.screen.teacher.TeacherTimeTableScreen

fun NavGraphBuilder.teacherGraph(navController: NavController){

    navigation(
        startDestination = NavigationRoutes.TeacherDashboard.route,
        route = NavigationRoutes.TeacherRoot.route
    ){

        composable(NavigationRoutes.TeacherDashboard.route){
            RoleScaffold(
                role = "Teacher",
                selectedItem = "Dashboard",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> {}
                        "Timetable" -> navController.navigate(NavigationRoutes.TeacherTimetable.route)
                        "Exams" -> navController.navigate(NavigationRoutes.TeacherExams.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Leave" -> navController.navigate(NavigationRoutes.TeacherLeave.route)
                        "Performance" -> navController.navigate(NavigationRoutes.TeacherPerformance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                TeacherDashboardScreen()
            }
        }

        composable(NavigationRoutes.TeacherTimetable.route){
            RoleScaffold(
                role = "Teacher",
                selectedItem = "Timetable",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.TeacherDashboard.route)
                        "Timetable" -> {}
                        "Exams" -> navController.navigate(NavigationRoutes.TeacherExams.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Leave" -> navController.navigate(NavigationRoutes.TeacherLeave.route)
                        "Performance" -> navController.navigate(NavigationRoutes.TeacherPerformance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                TeacherTimeTableScreen()
            }
        }

        composable(NavigationRoutes.TeacherExams.route){
            RoleScaffold(
                role = "Teacher",
                selectedItem = "Exams",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.TeacherDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.TeacherTimetable.route)
                        "Exams" -> {}
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Leave" -> navController.navigate(NavigationRoutes.TeacherLeave.route)
                        "Performance" -> navController.navigate(NavigationRoutes.TeacherPerformance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                TeacherExamScreen()
            }
        }

        composable(NavigationRoutes.AdminAttendance.route){
            RoleScaffold(
                role = "Teacher",
                selectedItem = "Attendance",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.TeacherDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.TeacherTimetable.route)
                        "Exams" -> navController.navigate(NavigationRoutes.TeacherExams.route)
                        "Attendance" -> {}
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Leave" -> navController.navigate(NavigationRoutes.TeacherLeave.route)
                        "Performance" -> navController.navigate(NavigationRoutes.TeacherPerformance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminAttendanceScreen()
            }
        }

        composable(NavigationRoutes.TeacherAssignment.route){
            RoleScaffold(
                role = "Teacher",
                selectedItem = "Assignments",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.TeacherDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.TeacherTimetable.route)
                        "Exams" -> navController.navigate(NavigationRoutes.TeacherExams.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.TeacherAttendance.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Assignments" -> {}
                        "Leave" -> navController.navigate(NavigationRoutes.TeacherLeave.route)
                        "Performance" -> navController.navigate(NavigationRoutes.TeacherPerformance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                TeacherAssignmentScreen()
            }
        }

        composable(NavigationRoutes.TeacherStudyMaterial.route){
            RoleScaffold(
                role = "Teacher",
                selectedItem = "Study Material",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.TeacherDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.TeacherTimetable.route)
                        "Exams" -> navController.navigate(NavigationRoutes.TeacherExams.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Study Material" ->{}
                        "Assignments" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Leave" -> navController.navigate(NavigationRoutes.TeacherLeave.route)
                        "Performance" -> navController.navigate(NavigationRoutes.TeacherPerformance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                TeacherStudyMaterialScreen()
            }
        }

        composable(NavigationRoutes.TeacherLeave.route){
            RoleScaffold(
                role = "Teacher",
                selectedItem = "Leave",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.TeacherDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.TeacherTimetable.route)
                        "Exams" -> navController.navigate(NavigationRoutes.TeacherExams.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Leave" -> {}
                        "Performance" -> navController.navigate(NavigationRoutes.TeacherPerformance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                TeacherLeaveScreen()
            }
        }

        composable(NavigationRoutes.TeacherPerformance.route){

            RoleScaffold(
                role = "Teacher",
                selectedItem = "Performance",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.TeacherDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.TeacherTimetable.route)
                        "Exams" -> navController.navigate(NavigationRoutes.TeacherExams.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Leave" -> navController.navigate(NavigationRoutes.TeacherLeave.route)
                        "Performance" -> {}
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                TeacherPerformanceScreen()
            }
        }


    }
}