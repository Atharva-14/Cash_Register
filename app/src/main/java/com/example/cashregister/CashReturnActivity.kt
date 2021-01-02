package com.example.cashregister

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CashReturnActivity : AppCompatActivity() {

    lateinit var tThousand: TextView
    lateinit var fHundred: TextView
    lateinit var tHundred: TextView
    lateinit var hundred: TextView
    lateinit var fifty: TextView
    lateinit var twenty: TextView
    lateinit var ten: TextView
    lateinit var five: TextView
    lateinit var two: TextView
    lateinit var one: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_return)

        tThousand = findViewById(R.id.tThousand)
        fHundred = findViewById(R.id.fHundred)
        tHundred = findViewById(R.id.tHundred)
        hundred = findViewById(R.id.Hundred)
        fifty = findViewById(R.id.fifty)
        twenty = findViewById(R.id.twenty)
        ten = findViewById(R.id.ten)
        five = findViewById(R.id.five)
        two = findViewById(R.id.two)
        one = findViewById(R.id.one)

        val amountView: TextView = findViewById(R.id.cashReturn)

        val intent = intent
        val amount = intent.getIntExtra("Amount", 0)
        val cash = calculate(amount)
        amountView.text = amountView.text.toString() + amount


        tThousand.text = cash.a.toString()
        fHundred.text = cash.b.toString()
        tHundred.text = cash.c.toString()
        hundred.text = cash.d.toString()
        fifty.text = cash.e.toString()
        twenty.text = cash.f.toString()
        ten.text = cash.g.toString()
        five.text = cash.h.toString()
        two.text = cash.i.toString()
        one.text = cash.j.toString()

        if (cash.a.toString() != "0") {
            tThousand.setTypeface(null, Typeface.BOLD)
        }
        if (cash.b.toString() != "0") {
            fHundred.setTypeface(null, Typeface.BOLD)
        }
        if (cash.c.toString() != "0") {
            tHundred.setTypeface(null, Typeface.BOLD)
        }
        if (cash.d.toString() != "0") {
            hundred.setTypeface(null, Typeface.BOLD)
        }
        if (cash.e.toString() != "0") {
            fifty.setTypeface(null, Typeface.BOLD)
        }
        if (cash.f.toString() != "0") {
            twenty.setTypeface(null, Typeface.BOLD)
        }
        if (cash.g.toString() != "0") {
            ten.setTypeface(null, Typeface.BOLD)
        }
        if (cash.h.toString() != "0") {
            five.setTypeface(null, Typeface.BOLD)
        }
        if (cash.i.toString() != "0") {
            two.setTypeface(null, Typeface.BOLD)
        }
        if (cash.j.toString() != "0") {
            one.setTypeface(null, Typeface.BOLD)
        }
    }
    private fun calculate(amount: Int): Return {
        var tThousand = 0
        var fHundred = 0
        var tHundred = 0
        var hundred = 0
        var fifty = 0
        var twenty = 0
        var ten = 0
        var five = 0
        var two = 0
        var one = 0

        var n = amount
        while (n > 0) {
            when {
                n >= 2000 -> {
                    tThousand += 1
                    n -= 2000
                }
                n >= 500 -> {
                    fHundred += 1
                    n -= 500
                }
                n >= 200 -> {
                    tHundred += 1
                    n -= 200
                }
                n >= 100 -> {
                    hundred += 1
                    n -= 100
                }
                n >= 50 -> {
                    fifty += 1
                    n -= 50
                }
                n >= 20 -> {
                    twenty += 1
                    n -= 20
                }
                n >= 10 -> {
                    ten += 1
                    n -= 10
                }
                n >= 5 -> {
                    five += 1
                    n -= 5
                }
                n >= 2 -> {
                    two += 1
                    n -= 2
                }
                n >= 1 -> {
                    one += 1
                    n -= 1
                }
                else -> {
                    print("Insufficient Amount")

                }
            }
        }

        val returnCash = Return(
            tThousand,
            fHundred,
            tHundred,
            hundred,
            fifty,
            twenty,
            ten,
            five,
            two,
            one
        )

        return returnCash

    }
}