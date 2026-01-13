package com.nexifotech.edumanage.models

data class ExpenseListModel(
    val date: String,
    val category: String,
    val vendor: String,
    val paymentMode: String,
    val amount: Int
)
