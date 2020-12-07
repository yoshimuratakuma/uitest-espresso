package com.example.uitest_espresso.utils

open class Validator {
    open fun isValidNumber(text: String): Boolean {
        return text.matches(Regex("[0-9]+"))
    }
    open fun isValidOperator(text: String): Boolean {
        return text.matches(Regex("""[-+*/]"""))
    }
}

class StubValidator(private val isNumber: Boolean, private val isOperator: Boolean): Validator() {
    override fun isValidNumber(text: String): Boolean {
        return isNumber
    }
    override fun isValidOperator(text: String): Boolean {
        return isOperator
    }
}