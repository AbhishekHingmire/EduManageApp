package com.nexifotech.edumanage.models

data class TeacherTodayClassesModel(
    val className: String,
    val timing: String,
    val studentCount: Int,
    val roomNo: String
)
