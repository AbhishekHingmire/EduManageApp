package com.nexifotech.edumanage.models

data class CreateBatchModel(
    val batchName: String,
    val batchTeacher: String,
    val studentsCount: Int,
    val batchCapacity: Int,
    val subjects: List<String>
)
