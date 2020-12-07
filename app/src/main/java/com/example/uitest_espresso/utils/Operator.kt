package com.example.uitest_espresso.utils

class Operator {

    enum class CalcResult {
        SUCCESS,
        FAIL_NUMBER_VALIDATOR,
        FAIL_OPERATOR_VALIDATOR,
        FAIL_ZERO_DEVISION
    }

    fun calcTextNumber(strNum1: String, strNum2: String, operator: String): Pair<CalcResult, String> {
        val validator = Validator()
        if (!validator.isValidNumber(strNum1)) {
            return CalcResult.FAIL_NUMBER_VALIDATOR to "数字を入力してください"
        }
        if (!validator.isValidNumber(strNum2)) {
            return CalcResult.FAIL_NUMBER_VALIDATOR to "数字を入力してください"
        }
        if (!validator.isValidOperator(operator)) {
            return CalcResult.FAIL_OPERATOR_VALIDATOR to "+, -, *, /のいずれかを入力してください"
        }
        if (operator == "/" && strNum2 == "0") {
            return CalcResult.FAIL_ZERO_DEVISION to "+, -, *, /のいずれかを入力してください"
        }

        return when (operator) {
            "+" -> CalcResult.SUCCESS to (strNum1.toInt() + strNum2.toInt()).toString()
            "-" -> CalcResult.SUCCESS to (strNum1.toInt() - strNum2.toInt()).toString()
            "*" -> CalcResult.SUCCESS to (strNum1.toInt() * strNum2.toInt()).toString()
            "/" -> CalcResult.SUCCESS to (strNum1.toInt() / strNum2.toInt()).toString()
            else -> CalcResult.SUCCESS to (strNum1.toFloat() + strNum2.toFloat()).toString()
        }
    }
}