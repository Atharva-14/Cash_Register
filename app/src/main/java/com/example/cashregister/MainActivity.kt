package com.example.cashregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var billAmt: TextInputEditText
    lateinit var cashGiven: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billAmt = findViewById(R.id.billAmt)
        cashGiven = findViewById(R.id.cashGiven)
    }

    fun submit(view: View) {

        var x: Int = cashGiven.text.toString().toInt()
        var y: Int = billAmt.text.toString().toInt()
        var amount: Int = x.minus(y)
        Log.i("Amount", amount.toString())
        val intent = Intent(this, CashReturnActivity::class.java)
        intent.putExtra("Amount", amount)
        startActivity(intent)
    }
}