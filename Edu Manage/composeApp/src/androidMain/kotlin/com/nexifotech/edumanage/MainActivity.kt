package com.nexifotech.edumanage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nexifotech.edumanage.navigation.AppRootNav
import com.nexifotech.edumanage.screen.admin.AdminAttendanceScreen
import com.nexifotech.edumanage.screen.admin.AdminCompletedExamCard
import com.nexifotech.edumanage.screen.admin.AdminDashBoardScreen
import com.nexifotech.edumanage.screen.admin.AdminExamsScreen
import com.nexifotech.edumanage.screen.admin.AdminFacultyScreen
import com.nexifotech.edumanage.screen.admin.AdminFinanceScreen
import com.nexifotech.edumanage.screen.admin.AdminStudentScreen
import com.nexifotech.edumanage.screen.admin.AdminTimetableCard
import com.nexifotech.edumanage.screen.admin.AdminTimetableScreen
import com.nexifotech.edumanage.screen.admin.AdminUpcomingExamCard
import com.nexifotech.edumanage.screen.admin.FeesRecordCard
import com.nexifotech.edumanage.screen.student.StudentAssignmentScreen
import com.nexifotech.edumanage.screen.student.StudentAttendanceScreen
import com.nexifotech.edumanage.screen.student.StudentDashBoardScreen
import com.nexifotech.edumanage.screen.student.StudentDoubtScreen
import com.nexifotech.edumanage.screen.student.StudentExamScreen
import com.nexifotech.edumanage.screen.student.StudentStudyMaterialScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            AppRootNav()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AdminAttendanceScreen()
}