package com.nexifotech.edumanage.screen.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexifotech.edumanage.common.AddButton
import com.nexifotech.edumanage.common.ScreenHeaderText
import com.nexifotech.edumanage.common.ScreenSubHeaderText
import com.nexifotech.edumanage.common.Text12Normal
import com.nexifotech.edumanage.common.Text12Primary
import com.nexifotech.edumanage.common.Text14Normal
import com.nexifotech.edumanage.common.Text14SemiBold
import com.nexifotech.edumanage.common.Text16Bold
import com.nexifotech.edumanage.models.ExpenseListModel
import com.nexifotech.edumanage.models.FinanceStateModel
import com.nexifotech.edumanage.models.ReportTabModel
import com.nexifotech.edumanage.models.SalaryModel
import com.nexifotech.edumanage.theme.AppColors
import edumanage.composeapp.generated.resources.Res
import edumanage.composeapp.generated.resources.person
import edumanage.composeapp.generated.resources.report
import edumanage.composeapp.generated.resources.rupee
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import kotlin.math.exp

@Composable
fun AdminFinanceScreen(){

    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Expense","Salary","Report","Fees")

    var reportList = listOf(
        ReportTabModel(AppColors.lightBlue, AppColors.blueColor, Res.drawable.report,"Profit & Loss Statement", "Comprehensive P&L report"),
        ReportTabModel(AppColors.lightGreen, AppColors.greenColor, Res.drawable.rupee,"Cash Flow Statement", "Track cash inflows & outflows"),
        ReportTabModel(AppColors.lightBlue, AppColors.blueColor, Res.drawable.report,"Balance Sheet", "Assets, liabilities & net worth"),
        ReportTabModel(AppColors.lightGreen, AppColors.greenColor, Res.drawable.rupee,"Tax Reports (GST)", "GST compliance reports")
    )

    var salaryList = listOf(
        SalaryModel("Mr. Sharma", 45000,"11/1/2024","Paid"),
        SalaryModel("Mrs. Patel", 42000,"11/1/2024","Paid"),
        SalaryModel("Ms. Khan", 40000,"10/1/2024","Pending"),
    )

    val expenseList = listOf(
        ExpenseListModel("11/15/2024","Salaries","Staff Payroll","Bank Transfer",250000),
        ExpenseListModel("11/10/2024","Rent","Property Owner","Bank Transfer",40000),
        ExpenseListModel("11/8/2024","Utilities","Electricity Board","Online",15000),
        ExpenseListModel("11/5/2024","Stationery","Office Supply","Cash",8000)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.background)
            .padding(14.dp,0.dp)
    ){
        item {
            Spacer(modifier = Modifier.height(20.dp))
            ScreenHeaderText("Finance Dashboard")

            Spacer(modifier = Modifier.height(5.dp))

            ScreenSubHeaderText("Manage expenses, income, and financial reports")

            AddButton("Export Report",{})

            FinancesStateCard(FinanceStateModel("Total Revenue",500000,"+12%", Res.drawable.report,
                AppColors.blueColor, AppColors.lightBlue))
            FinancesStateCard(FinanceStateModel("Total Expenses",320000,"This month", Res.drawable.report,
                AppColors.redColor, AppColors.lightRed))
            FinancesStateCard(FinanceStateModel("Net Profit",180000,"36% margin", Res.drawable.rupee,
                AppColors.greenColor, AppColors.lightGreen))
            FinancesStateCard(FinanceStateModel("Outstanding Dues",120000,"From students", Res.drawable.rupee,
                AppColors.orengeColor, AppColors.lightOrange))


        }
        /* ---------- Tabs ---------- */
        item {
            Spacer(modifier = Modifier.height(14.dp))

            Row(modifier = Modifier.fillMaxWidth()
                .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
                .padding(5.dp)
            ){
                tabs.forEachIndexed { index, string ->
                    val isSelected = index == selectedTab

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                if (isSelected) AppColors.primaryColor else Color.Transparent,
                                RoundedCornerShape(7.dp)
                            )
                            .clickable{selectedTab = index}
                            .padding(7.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = string,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isSelected) Color.White else AppColors.textColorPrimary,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
        }

        when(selectedTab){
            0->{
                items(expenseList){
                    ExpenseCard(it)
                }
            }

            1->{
                items(salaryList){
                    SalariesCard(it)
                }
            }

            2->{
                items(reportList){
                    ReportCard(
                        it.backgroundColor,
                        it.iconColor,
                        it.icon,
                        it.text,
                        it.description
                    )
                }
            }
            3->{
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Box(
                            modifier = Modifier.fillMaxWidth().height(35.dp).weight(1f)
                                .background(AppColors.background,RoundedCornerShape(7.dp))
                                .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                                .padding(5.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text12Primary("Send Fee Reminders")
                        }
                        Spacer(Modifier.width(10.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth().height(35.dp).weight(1f)
                                .background(AppColors.primaryColor,RoundedCornerShape(7.dp))
                                .padding(5.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text12Primary("Record Fee Payment")
                        }
                    }
                    Spacer(Modifier.height(14.dp))

                    Text16Bold("Student Fee Record")
                    Text12Normal("Track and manage student fee payments")
                    Spacer(Modifier.height(14.dp))

                    FeesRecordCard("Paid")
                    FeesRecordCard("Overdue")
                    FeesRecordCard("Pending")
                }
            }
        }


    }
}


@Composable
fun FinancesStateCard(model: FinanceStateModel){

    Row(
        modifier = Modifier.fillMaxWidth()
            .background(color = AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp,AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ){
        Column(modifier = Modifier.weight(1f)){
            Text12Normal(model.title)

            Spacer(Modifier.height(5.dp))

            Text16Bold("$${model.data}")

            Spacer(Modifier.height(5.dp))

            Text12Normal(model.text)
        }

        Box(
            modifier = Modifier
                .background(model.lightColor,RoundedCornerShape(50))
                .padding(10.dp)
        ){
            Icon(
                painterResource(model.icon),
                "",
                tint = model.color,
                modifier = Modifier.size(20.dp)
            )
        }
    }
    Spacer(Modifier.height(14.dp))
}

@Composable
fun ExpenseCard(model: ExpenseListModel){

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
        .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
        .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                modifier = Modifier.weight(1f)
            ){
                Text12Normal("Amount")
                Text14SemiBold("$${model.amount}")
            }

            Box(
                modifier = Modifier
                    .background(AppColors.cardBackground, RoundedCornerShape(20.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(20.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text12Primary(model.category)
            }

        }

        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(){
                Text12Normal("Date")
                Text14SemiBold(model.date)
            }
            Spacer(Modifier.width(7.dp))
            Column(){
                Text12Normal("Vendor")
                Text14SemiBold(model.vendor)
            }
            Spacer(Modifier.width(7.dp))
            Column(){
                Text12Normal("Payment Mode")
                Text14SemiBold(model.paymentMode)
            }
        }

        Spacer(Modifier.height(12.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier )

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier.fillMaxWidth().height(40.dp).weight(1f)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
               Text14Normal("Edit")
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth().height(40.dp).weight(1f)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
               Text14Normal("Delete")
            }
        }


    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun SalariesCard(model: SalaryModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.cardBackground, RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text14SemiBold(model.teacher)

            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        when(model.status){
                            "Paid" -> AppColors.greenColor
                            "Pending" -> AppColors.redColor
                            else -> AppColors.cardBackground
                        }
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ){
                Text(model.status, color = Color.White, fontSize = 12.sp)
            }
        }

        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Text12Normal("Monthly Salary: ")
            Text12Primary("$${model.salary}")

            Spacer(Modifier.width(20.dp))

            Text12Normal("Last Paid: ")
            Text12Primary(model.lastPaid)
        }

        Spacer(Modifier.height(12.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier )

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Box(
                modifier = Modifier.fillMaxWidth().height(40.dp).weight(1f)
                    .background(AppColors.background,RoundedCornerShape(10.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(10.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
                Text14Normal("Pay Salary")
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth().height(40.dp).weight(1f)
                    .background(AppColors.background,RoundedCornerShape(10.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(10.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
               Text14Normal("History")
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun ReportCard(backgroundColor: Color,iconColor: Color,icon: DrawableResource,text: String, description: String){
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp),
    ){
        Box(
            modifier = Modifier
                .background(backgroundColor,RoundedCornerShape(50))
                .padding(7.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                painterResource(icon),
                "",
                tint = iconColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(Modifier.width(10.dp))

        Column(){
            Text14SemiBold(text)

            Spacer(Modifier.height(5.dp))
            Text12Normal(description)
        }

    }

    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun FeesRecordCard(staus: String){
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
            .background(color = AppColors.cardBackground,RoundedCornerShape(7.dp))
            .border(1.dp,AppColors.borderColor,RoundedCornerShape(7.dp))
            .padding(16.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            // Profile Icon Placeholder
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(AppColors.background, RoundedCornerShape(50)),
                contentAlignment = Alignment.Center

            ){
                Icon(
                    painterResource(Res.drawable.person),
                    "",
                    tint = AppColors.textColorPrimary,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(Modifier.width(8.dp))

            Column() {
                Text14SemiBold("Rahul Sharma")

                Text12Normal("ID: ADM001 | Batch: Grade 10-A")
            }

            Spacer(Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.End
            ){
                Text12Normal("Status  ")
                Spacer(Modifier.height(1.dp))
                // Status Label
                Box(
                    modifier = Modifier
                        .background(color =
                            when(staus){
                                "Paid"-> AppColors.greenColor
                                "Pending"-> AppColors.primaryColor
                                "Overdue"-> AppColors.redColor
                                else -> AppColors.background
                            }, RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(staus, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(){
                Text12Normal("Fee Type")
                Spacer(Modifier.height(1.dp))
                Text14SemiBold("Yearly")
            }
            //Spacer(Modifier.width(7.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text12Normal("Total Paid")
                Spacer(Modifier.height(1.dp))
                Text("$25,000", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = AppColors.greenColor)
            }
            //Spacer(Modifier.width(7.dp))

            Column(
                horizontalAlignment = Alignment.End
            ){
                Text12Normal("Total Due")
                Spacer(Modifier.height(1.dp))
                Text("$25,000", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = AppColors.redColor)
            }
        }

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(){
                Text12Normal("Due Date")
                Spacer(Modifier.height(1.dp))
                Text14SemiBold("Dec 5, 2025")
            }

            //Spacer(Modifier.width(7.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text12Normal("Last Payment")
                Spacer(Modifier.height(1.dp))
                Text14SemiBold("Nov 15, 2025")
                Spacer(Modifier.height(1.dp))
                Text12Normal("$5,000")
            }
            //Spacer(Modifier.width(7.dp))
            Column(
                horizontalAlignment = Alignment.End
            ){
                Text12Normal("Fee Amount")
                Spacer(Modifier.height(1.dp))
                Text14SemiBold("$60,000")
                Spacer(Modifier.height(1.dp))
                Text12Normal("$5,000/month")
            }
        }

        Spacer(Modifier.height(14.dp))

        Divider(color = AppColors.borderColor, modifier = Modifier )

        Spacer(Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Box(
                modifier = Modifier.fillMaxWidth().height(35.dp).weight(1f)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
                Text12Primary("Pay")
            }
            Spacer(Modifier.width(10.dp))
            Box(
                modifier = Modifier.fillMaxWidth().height(35.dp).weight(1f)
                    .background(AppColors.background,RoundedCornerShape(7.dp))
                    .border(1.dp, AppColors.borderColor,RoundedCornerShape(7.dp))
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ){
                Text12Primary("History")
            }
        }
    }
}
