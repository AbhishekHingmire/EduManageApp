package com.nexifotech.edumanage.models

data class StudentCompleteAssignmentModel(
    val title: String,
    val completeDate: String,
    val subject: String,
    val totalMarks: Int,
    val marksObtain: Int
)
