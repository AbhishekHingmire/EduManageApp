package com.nexifotech.edumanage.models

data class CreateAssignmentModel(
    val title: String,
    val subject: String,
    val status: String,
    val description: String,
    val date: String,
    val totalMarks: Int
)
