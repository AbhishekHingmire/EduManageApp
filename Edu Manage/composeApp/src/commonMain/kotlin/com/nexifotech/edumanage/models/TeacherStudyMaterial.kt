package com.nexifotech.edumanage.models

data class TeacherStudyMaterial(
    val materialTitle: String,
    val subject: String,
    val topic: String,
    val batch: List<String>
)
