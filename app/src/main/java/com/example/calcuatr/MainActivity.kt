package com.example.calcuatr
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private var currentInput: String = ""
    private var operator: String = ""
    private var firstOperand: Double = 0.0
    private var isOperatorPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
    }

    fun onDigit(view: View) {
        if (isOperatorPressed) {
            currentInput = ""
            isOperatorPressed = false
        }
        currentInput += (view as Button).text.toString()
        tvResult.text = currentInput
    }
    @Suppress("UNUSED_PARAMETER")

    fun onClear(view: View) {
        currentInput = ""
        firstOperand = 0.0
        operator = ""
        isOperatorPressed = false
        tvResult.text = getString(R.string.tv_result_initial) // Reset to initial string
    }


    fun onOperator(view: View) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            operator = (view as Button).text.toString()
            isOperatorPressed = true
        }
    }
    @Suppress("UNUSED_PARAMETER")
    fun onEqual(view: View)  {
        if (currentInput.isNotEmpty()) {
            val secondOperand = currentInput.toDouble()

            when (operator) {
                "+" -> currentInput = (firstOperand + secondOperand).toString()
                "-" -> currentInput = (firstOperand - secondOperand).toString()
                "*" -> currentInput = (firstOperand * secondOperand).toString()
                "/" -> currentInput = if (secondOperand != 0.0) {
                    (firstOperand / secondOperand).toString()
                } else {
                    "Error"
                }
            }

            tvResult.text = currentInput
        }
    }

}
