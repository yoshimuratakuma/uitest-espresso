package com.example.uitest_espresso.utils

open class InputChecker {

    var errMsg: String = ""

    open fun canCalc(input: InputNumbers, validator: Validator): Boolean {
        if (!validator.isValidNumber(input.num1)) {
            errMsg = "数字を入力してください"
            return false
        }
        if (!validator.isValidNumber(input.num2)) {
            errMsg = "数字を入力してください"
            return false
        }
        if (!validator.isValidOperator(input.operator)) {
            errMsg = "+, -, *, /のいずれかを入力してください"
            return false
        }
        if (input.operator == "/" && input.num2 == "0") {
            errMsg = "0で割らないでください"
            return false
        }
        return true
    }
}