package com.nexifotech.edumanage.models

data class StudentPendingAssinmentModel(
    val title: String,
    val date: String,
    val marks: String,
    val dueDays: Int,
    val subject: String
)
