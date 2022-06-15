package com.example.budgettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    private lateinit var transactions : ArrayList<Transaction>
    private lateinit var transactionAdapter : TransactionAdapter
    private lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transactions = arrayListOf(
            Transaction("budget", 800.00),
            Transaction("movie", -20.00),
            Transaction("whiskey", -80.00),
            Transaction("pizza", -30.00),
            Transaction("Gas", -50.00)
        )

        transactionAdapter = TransactionAdapter(transactions)
        linearLayoutManager = LinearLayoutManager(this)

        val recycler = findViewById<RecyclerView>(R.id.recyclerview)

        recycler.apply {
            adapter = transactionAdapter
            layoutManager = linearLayoutManager
        }

        updateDashboard()
    }

    private fun updateDashboard() {
        // it <-- refers to the elements in transactions
        val totalAmount = transactions.map { it.amount }.sum() // iterates over the ArrayList of transactions and returns only the amounts and sums them up
        val budgetAmount = transactions.filter { it.amount>0 }.map { it.amount }.sum() // returns only the amounts greater than 0 and sums them up
        val expenseAmount =  totalAmount - budgetAmount

        var balance = findViewById<TextView>(R.id.balance)
        var budget = findViewById<TextView>(R.id.budget)
        var expense = findViewById<TextView>(R.id.expense)

        balance.text = "$ %.2f".format(totalAmount)
        budget.text = "$ %.2f".format(budgetAmount)
        expense.text = "$ %.2f".format(expenseAmount)
    }
}