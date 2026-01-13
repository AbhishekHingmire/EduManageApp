package com.nexifotech.edumanage.models

data class StudentDashboardUpcomingAssignmentModel(
    val title: String,
    val subject: String,
    val date: String,
    val marks: Int,
    val daysLeft: Int
)
