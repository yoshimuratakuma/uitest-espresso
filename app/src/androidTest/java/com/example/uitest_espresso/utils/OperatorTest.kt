package com.example.uitest_espresso.utils

import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class OperatorTest {
    lateinit var target: Operator

    @Before
    fun setUp() {
        target = Operator()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun calcTextNumber_given_validValues_returnsSuccess() {
    }
}