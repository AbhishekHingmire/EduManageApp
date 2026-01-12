package com.nexifotech.edumanage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nexifotech.edumanage.screen.student.StudentAssignmentScreen
import com.nexifotech.edumanage.screen.student.StudentAttendanceScreen
import com.nexifotech.edumanage.screen.student.StudentDashBoardScreen
import com.nexifotech.edumanage.screen.student.StudentDoubtScreen
import com.nexifotech.edumanage.screen.student.StudentExamScreen
import com.nexifotech.edumanage.screen.student.StudentStudyMaterialScreen
import com.nexifotech.edumanage.screen.student.StudentTimetableScreen

fun NavGraphBuilder.studentGraph(navController: NavController){

    navigation(
        startDestination = NavigationRoutes.StudentDashboard.route,
        route = NavigationRoutes.StudentRoot.route
    ){

        composable (NavigationRoutes.StudentDashboard.route){
            RoleScaffold(
                role = "Student",
                selectedItem = "Dashboard",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> {}
                        "Timetable" -> navController.navigate(NavigationRoutes.StudentTimetable.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.StudentAssignment.route)
                        "Exams" -> navController.navigate(NavigationRoutes.StudentExams.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.StudentStudyMaterial.route)
                        "Doubts" -> navController.navigate(NavigationRoutes.StudentDoubts.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.StudentAttendance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }
                    }
                }
            ){
                StudentDashBoardScreen()
            }
        }

        composable(NavigationRoutes.StudentTimetable.route){
            RoleScaffold(
                role = "Student",
                selectedItem = "Timetable",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.StudentDashboard.route)
                        "Timetable" -> {}
                        "Assignments" -> navController.navigate(NavigationRoutes.StudentAssignment.route)
                        "Exams" -> navController.navigate(NavigationRoutes.StudentExams.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.StudentStudyMaterial.route)
                        "Doubts" -> navController.navigate(NavigationRoutes.StudentDoubts.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.StudentAttendance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                StudentTimetableScreen()
            }
        }

        composable(NavigationRoutes.StudentAssignment.route){
            RoleScaffold(
                role = "Student",
                selectedItem = "Assignments",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.StudentDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.StudentTimetable.route)
                        "Assignments" -> {}
                        "Exams" -> navController.navigate(NavigationRoutes.StudentExams.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.StudentStudyMaterial.route)
                        "Doubts" -> navController.navigate(NavigationRoutes.StudentDoubts.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.StudentAttendance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                StudentAssignmentScreen()
            }
        }

        composable(NavigationRoutes.StudentExams.route){
            RoleScaffold(
                role = "Student",
                selectedItem = "Exams",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.StudentDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.StudentTimetable.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.StudentAssignment.route)
                        "Exams" -> {}
                        "Study Material" -> navController.navigate(NavigationRoutes.StudentStudyMaterial.route)
                        "Doubts" -> navController.navigate(NavigationRoutes.StudentDoubts.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.StudentAttendance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                StudentExamScreen()
            }
        }

        composable(NavigationRoutes.StudentStudyMaterial.route){
            RoleScaffold(
                role = "Student",
                selectedItem = "Study Material",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.StudentDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.StudentTimetable.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.StudentAssignment.route)
                        "Exams" -> navController.navigate(NavigationRoutes.StudentExams.route)
                        "Study Material" -> {}
                        "Doubts" -> navController.navigate(NavigationRoutes.StudentDoubts.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.StudentAttendance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                StudentStudyMaterialScreen()
            }
        }

        composable(NavigationRoutes.StudentDoubts.route){
            RoleScaffold(
                role = "Student",
                selectedItem = "Doubts",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.StudentDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.StudentTimetable.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.StudentAssignment.route)
                        "Exams" -> navController.navigate(NavigationRoutes.StudentExams.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.StudentStudyMaterial.route)
                        "Doubts" -> {}
                        "Attendance" -> navController.navigate(NavigationRoutes.StudentAttendance.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                StudentDoubtScreen()
            }
        }

        composable(NavigationRoutes.StudentAttendance.route){
            RoleScaffold(
                role = "Student",
                selectedItem = "Attendance",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.StudentDashboard.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.StudentTimetable.route)
                        "Assignments" -> navController.navigate(NavigationRoutes.StudentAssignment.route)
                        "Exams" -> navController.navigate(NavigationRoutes.StudentExams.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.StudentStudyMaterial.route)
                        "Doubts" -> navController.navigate(NavigationRoutes.StudentDoubts.route)
                        "Attendance" -> {}
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                StudentAttendanceScreen()
            }
        }


    }
}