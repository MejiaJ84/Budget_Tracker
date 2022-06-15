package com.example.budgettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputLayout

class AddTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        val addTransactionBtn = findViewById<Button>(R.id.addTransaction)
        val labelInput = findViewById<TextView>(R.id.labelInput)
        val amountInput = findViewById<TextView>(R.id.amountInput)
        val labelLayout = findViewById<TextInputLayout>(R.id.labelLayout)
        val amountLayout = findViewById<TextInputLayout>(R.id.amountLayout)

        labelInput.doAfterTextChanged {
            if (it!!.count() > 0)
                labelLayout.error = null
        }

        amountInput.doAfterTextChanged {
            if (it!!.count() > 0)
                amountLayout.error = null
        }

        addTransactionBtn.setOnClickListener{
            val label = labelInput.toString()
            val amount = amountInput.toString().toDoubleOrNull()

            if (label.isEmpty()){
                labelLayout.error = "Please enter a valid label."
            }
            if (amount == null) {
                amountLayout.error = "Please enter a valid value."
            }
        }
    }
}