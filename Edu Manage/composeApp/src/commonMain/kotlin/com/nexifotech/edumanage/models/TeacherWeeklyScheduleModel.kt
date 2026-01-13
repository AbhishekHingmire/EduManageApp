package com.nexifotech.edumanage.models

data class TeacherWeeklyScheduleModel(
    val title: String,
    val subject: String,
    val days: List<String>,
    val time: String,
    val studentCount: Int
)
