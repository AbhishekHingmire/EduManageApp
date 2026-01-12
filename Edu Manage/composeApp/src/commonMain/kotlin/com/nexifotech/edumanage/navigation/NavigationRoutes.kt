package com.nexifotech.edumanage.navigation

sealed class NavigationRoutes (val route: String) {

    //common screens
    object Splash : NavigationRoutes("splash")
    object Login : NavigationRoutes("login")
    object Signup : NavigationRoutes("signup")
    object Setting : NavigationRoutes("setting")
    object Profile : NavigationRoutes("profile")

    //role roots
    object StudentRoot : NavigationRoutes("student_root")
    object TeacherRoot : NavigationRoutes("teacher_root")
    object AdminRoot : NavigationRoutes("admin_root")

    //student screens
    object StudentDashboard : NavigationRoutes("student_dashboard")
    object StudentTimetable : NavigationRoutes("student_timetable")
    object StudentAttendance : NavigationRoutes("student_attendance")
    object StudentStudyMaterial : NavigationRoutes("student_study_material")
    object StudentAssignment : NavigationRoutes("student_assignment")
    object StudentDoubts : NavigationRoutes("student_doubts")
    object StudentExams : NavigationRoutes("student_exams")

    //teacher screens
    object TeacherDashboard : NavigationRoutes("teacher_dashboard")
    object TeacherTimetable : NavigationRoutes("teacher_timetable")
    object TeacherExams : NavigationRoutes("teacher_exams")
    object TeacherAttendance : NavigationRoutes("teacher_attendance")
    object TeacherStudyMaterial : NavigationRoutes("teacher_study_material")
    object TeacherAssignment : NavigationRoutes("teacher_assignment")
    object TeacherLeave : NavigationRoutes("teacher_leave")
    object TeacherPerformance : NavigationRoutes("teacher_performance")

    //admin screens
    object AdminDashboard : NavigationRoutes("admin_dashboard")
    object AdminTimetable : NavigationRoutes("admin_timetable")
    object AdminExams : NavigationRoutes("admin_exams")
    object AdminAttendance : NavigationRoutes("admin_attendance")
    object AdminStudents : NavigationRoutes("admin_students")
    object AdminFaculty : NavigationRoutes("admin_faculty")
    object AdminBatches : NavigationRoutes("admin_batches")
    object AdminFinance : NavigationRoutes("admin_finance")
    object AdminReports : NavigationRoutes("admin_reports")
    object AdminAssignmentScreen: NavigationRoutes("admin_assignment")



}