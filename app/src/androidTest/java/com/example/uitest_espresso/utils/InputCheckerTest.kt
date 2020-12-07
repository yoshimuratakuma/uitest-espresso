package com.example.uitest_espresso.utils

import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class InputCheckerTest {

    lateinit var target: InputChecker

    @Before
    fun setUp() {
        target = InputChecker()
    }

    @After
    fun tearDown() {
    }

    // 入力された演算子が異常なとき
    @Test
    fun checkCanCalc_givenValidValues_returnsTrue() {
        // inputの値はなんでもいい
        val input = Operator.InputNumbers("11", "100", "+")
        val stubValidator = StubValidator(isNumber = true, isOperator = true)
        assertThat(target.canCalc(input, stubValidator), `is`(true))
    }

    // 入力された演算子が異常なとき
    @Test
    fun checkCanCalc_givenInvalidOperator_returnsFalse() {
        // inputの値はなんでもいい
        val input = Operator.InputNumbers("11", "100", "+")
        val stubValidator = StubValidator(isNumber = true, isOperator = false)
        assertThat(target.canCalc(input, stubValidator), `is`(false))
        assertThat(target.errMsg == "+, -, *, /のいずれかを入力してください", `is`(true))
    }

    // 入力された数字が異常なとき
    @Test
    fun checkCanCalc_givenInvalidNumber_returnsFalse() {
        // inputの値はなんでもいい
        val input = Operator.InputNumbers("11", "100", "+")
        val stubValidator = StubValidator(isNumber = false, isOperator = true)
        assertThat(target.canCalc(input, stubValidator), `is`(false))
        assertThat(target.errMsg == "数字を入力してください", `is`(true))
    }
}