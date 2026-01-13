package com.nexifotech.edumanage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nexifotech.edumanage.screen.admin.AdminAttendanceScreen
import com.nexifotech.edumanage.screen.admin.AdminBatchesScreen
import com.nexifotech.edumanage.screen.admin.AdminDashBoardScreen
import com.nexifotech.edumanage.screen.admin.AdminExamsScreen
import com.nexifotech.edumanage.screen.admin.AdminFacultyScreen
import com.nexifotech.edumanage.screen.admin.AdminFinanceScreen
import com.nexifotech.edumanage.screen.admin.AdminReportScreen
import com.nexifotech.edumanage.screen.admin.AdminStudentScreen
import com.nexifotech.edumanage.screen.admin.AdminTimetableScreen
import com.nexifotech.edumanage.screen.teacher.TeacherAssignmentScreen
import com.nexifotech.edumanage.screen.teacher.TeacherStudyMaterialScreen

fun NavGraphBuilder.adminGraph(navController: NavController){
    navigation(
        startDestination = NavigationRoutes.AdminDashboard.route,
        route = NavigationRoutes.AdminRoot.route
    ) {

        composable(NavigationRoutes.AdminDashboard.route) {
            RoleScaffold(
                role = "Admin",
                selectedItem = "Dashboard",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> {}
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminDashBoardScreen()
            }
        }

        composable(NavigationRoutes.AdminStudents.route) {
            RoleScaffold(
                role = "Admin",
                selectedItem = "Students",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> {}
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminStudentScreen()
            }
        }

        composable(NavigationRoutes.AdminFaculty.route) {

            RoleScaffold(
                role = "Admin",
                selectedItem = "Faculty",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> {}
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminFacultyScreen()
            }
        }

        composable(NavigationRoutes.AdminBatches.route) {

            RoleScaffold(
                role = "Admin",
                selectedItem = "Batches",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> {}
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminBatchesScreen()
            }
        }

        composable(NavigationRoutes.AdminTimetable.route) {

            RoleScaffold(
                role = "Admin",
                selectedItem = "Timetable",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> {}
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminTimetableScreen()
            }
        }

        composable(NavigationRoutes.AdminAttendance.route) {

            RoleScaffold(
                role = "Admin",
                selectedItem = "Attendance",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> {}
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
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

        composable(NavigationRoutes.AdminExams.route) {

            RoleScaffold(
                role = "Admin",
                selectedItem = "Exams",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> {}
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminExamsScreen()
            }
        }

        composable(NavigationRoutes.AdminFinance.route) {

            RoleScaffold(
                role = "Admin",
                selectedItem = "Finance",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> {}
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminFinanceScreen()
            }
        }

        composable(NavigationRoutes.AdminReports.route) {

            RoleScaffold(
                role = "Admin",
                selectedItem = "Report",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Report" -> {}
                        "Assignment" -> navController.navigate(NavigationRoutes.TeacherAssignment.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Logout" -> {
                            navController.navigate(NavigationRoutes.Login.route) {
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }

                    }
                }
            ){
                AdminReportScreen()
            }
        }

        composable(NavigationRoutes.TeacherAssignment.route) {
            RoleScaffold(
                role = "Admin",
                selectedItem = "Assignment",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Study Material" -> navController.navigate(NavigationRoutes.TeacherStudyMaterial.route)
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" ->{}
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

        composable(NavigationRoutes.TeacherStudyMaterial.route) {
            RoleScaffold(
                role = "Admin",
                selectedItem = "Study Material",
                onItemClick = {drawerItem->
                    when(drawerItem.title){
                        "Dashboard" -> navController.navigate(NavigationRoutes.AdminDashboard.route)
                        "Students" -> navController.navigate(NavigationRoutes.AdminStudents.route)
                        "Faculty" -> navController.navigate(NavigationRoutes.AdminFaculty.route)
                        "Batches" -> navController.navigate(NavigationRoutes.AdminBatches.route)
                        "Timetable" -> navController.navigate(NavigationRoutes.AdminTimetable.route)
                        "Attendance" -> navController.navigate(NavigationRoutes.AdminAttendance.route)
                        "Exams" -> navController.navigate(NavigationRoutes.AdminExams.route)
                        "Finance" -> navController.navigate(NavigationRoutes.AdminFinance.route)
                        "Study Material" -> {}
                        "Report" -> navController.navigate(NavigationRoutes.AdminReports.route)
                        "Assignment" ->navController.navigate(NavigationRoutes.TeacherAssignment.route)
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

    }
}