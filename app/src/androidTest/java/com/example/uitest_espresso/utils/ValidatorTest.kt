package com.example.uitest_espresso.utils

import androidx.test.espresso.matcher.ViewMatchers.assertThat
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest : TestCase() {

    public override fun setUp() {
        super.setUp()
    }

    public override fun tearDown() {}

    @Test
    fun isValidNumber_givenAlpha_returnsFalse() {
        val target = Validator()
        val actual = target.isValidNumber("a")
        assertThat(actual, `is`(false))
    }
}