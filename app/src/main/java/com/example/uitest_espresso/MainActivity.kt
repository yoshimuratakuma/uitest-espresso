package com.example.uitest_espresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

            val calcResult = Operator().calcTextNumber(edit_num1.text.toString(), edit_num2.text.toString(), edit_operator.text.toString())
            when (calcResult.first) {
                Operator.CalcResult.SUCCESS -> {
                    text_answer.text = calcResult.second
                }
                Operator.CalcResult.FAIL_NUMBER_VALIDATOR, Operator.CalcResult.FAIL_OPERATOR_VALIDATOR, Operator.CalcResult.FAIL_ZERO_DEVISION -> {
                    text_error.text = calcResult.second
                }
            }
        }
    }
}