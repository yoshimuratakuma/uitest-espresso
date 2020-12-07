package com.example.uitest_espresso.utils

class Operator {

    enum class CalcResult {
        SUCCESS,
        FAIL_NUMBER_VALIDATOR,
        FAIL_OPERATOR_VALIDATOR,
        FAIL_ZERO_DEVISION
    }

    data class InputNumbers(
        val num1: String,
        val num2: String,
        val operator: String
    )

    fun calcTextNumber(input: InputNumbers, validator: Validator): Pair<CalcResult, String> {
        if (!validator.isValidNumber(input.num1)) {
            return CalcResult.FAIL_NUMBER_VALIDATOR to "数字を入力してください"
        }
        if (!validator.isValidNumber(input.num2)) {
            return CalcResult.FAIL_NUMBER_VALIDATOR to "数字を入力してください"
        }
        if (!validator.isValidOperator(input.operator)) {
            return CalcResult.FAIL_OPERATOR_VALIDATOR to "+, -, *, /のいずれかを入力してください"
        }
        if (input.operator == "/" && input.num2 == "0") {
            return CalcResult.FAIL_ZERO_DEVISION to "0で割らないでください"
        }

        return when (input.operator) {
            "+" -> CalcResult.SUCCESS to (input.num1.toInt() + input.num2.toInt()).toString()
            "-" -> CalcResult.SUCCESS to (input.num1.toInt() - input.num2.toInt()).toString()
            "*" -> CalcResult.SUCCESS to (input.num1.toInt() * input.num1.toInt()).toString()
            "/" -> CalcResult.SUCCESS to (input.num1.toFloat() / input.num2.toFloat()).toString()
            else -> CalcResult.SUCCESS to (input.num1.toInt() + input.num2.toInt()).toString()
        }
    }
}