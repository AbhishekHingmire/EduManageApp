package com.nexifotech.edumanage.models

data class TeacherCreateExamModel(
    val examName: String,
    val examType: String,
    val subject: String,
    val batches: Int,
    val date: String,
    val duration: String,
    val totalMarks: String
)
