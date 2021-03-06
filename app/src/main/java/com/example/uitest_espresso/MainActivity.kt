package com.example.uitest_espresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uitest_espresso.utils.InputChecker
import com.example.uitest_espresso.utils.InputNumbers
import com.example.uitest_espresso.utils.Operator
import com.example.uitest_espresso.utils.Validator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCalcBtn()
    }

    private fun setCalcBtn() {
        btn_calc.setOnClickListener {
            text_error.text = ""
            text_answer.text = ""

            val input = InputNumbers(edit_num1.text.toString(), edit_num2.text.toString(), edit_operator.text.toString())
            val inputChecker = InputChecker()
            if (!inputChecker.canCalc(input, Validator())) {
                text_error.text = inputChecker.errMsg
                return@setOnClickListener
            }
            text_answer.text = Operator().calc(input)
        }
    }
}