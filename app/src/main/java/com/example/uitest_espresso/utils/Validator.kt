package com.example.uitest_espresso.utils

class Validator {
    fun isValidNumber(text: String): Boolean {
        return text.matches(Regex("[0-9]+"))
    }
    fun isValidOperator(text: String): Boolean {
        return text.matches(Regex("""[-+*/]"""))
    }
}