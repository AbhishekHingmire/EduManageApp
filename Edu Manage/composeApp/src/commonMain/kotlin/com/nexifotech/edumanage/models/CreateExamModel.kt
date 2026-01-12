package com.nexifotech.edumanage.models

data class CreateExamModel(
    val examName: String,
    val date: String,
    val duration: String,
    val totalMarks: Int,
    val passingMarks: Int,
    val subjects: List<String>
)
