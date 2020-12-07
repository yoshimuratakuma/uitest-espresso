package com.example.uitest_espresso.utils

class Operator {
    fun calc(input: InputNumbers): String {
        return when (input.operator) {
            "+" -> (input.num1.toInt() + input.num2.toInt()).toString()
            "-" ->  (input.num1.toInt() - input.num2.toInt()).toString()
            "*" -> (input.num1.toInt() * input.num1.toInt()).toString()
            "/" -> (input.num1.toFloat() / input.num2.toFloat()).toString()
            else -> (input.num1.toInt() + input.num2.toInt()).toString()
        }
    }
}