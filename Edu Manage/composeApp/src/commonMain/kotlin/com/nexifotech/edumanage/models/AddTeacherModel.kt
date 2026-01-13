package com.nexifotech.edumanage.models

data class AddTeacherModel(
    val name: String,
    val id: String,
    val batches: Int,
    val subjects: List<String>
)
