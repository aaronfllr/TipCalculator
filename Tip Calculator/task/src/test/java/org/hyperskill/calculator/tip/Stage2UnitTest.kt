package org.hyperskill.calculator.tip

import org.hyperskill.calculator.tip.internals.TipCalculatorUnitTest
import org.hyperskill.calculator.tip.internals.screen.TipCalculatorScreen
import org.hyperskill.calculator.tip.internals.screen.TipCalculatorScreen.Companion.idEditText
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner

// Version 3.0
@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Stage2UnitTest : TipCalculatorUnitTest<MainActivity>(MainActivity::class.java) {


    @Test
    fun test00_whenEditTextEmtpyThenTipAndBillTextViewsAreEmpty() {
        testActivity {
            TipCalculatorScreen(this).apply {
                setTipPercent(tipPercent = 20)

                val caseDescription = "\"$idEditText\" text is empty"
                assertTipPercentIsEmpty(caseDescription)
                assertBillValueIsEmpty(caseDescription)
            }
        }
    }

    @Test
    fun test01_whenEditTextIsZeroThenTipAndBillTextViewsAreEmpty() {
        testActivity {
            TipCalculatorScreen(this).apply {
                setBillAmount("0")

                val caseDescription = "\"$idEditText\" text is 0"
                assertTipPercentIsEmpty(caseDescription)
                assertBillValueIsEmpty(caseDescription)
            }
        }
    }

    @Test
    fun test02_checkValueWithInitialTip() {
        testActivity {
            TipCalculatorScreen(this).apply {
                val billValueToTest = 50
                setBillAmount("$billValueToTest")
                val tipToTest = 15

                val caseDescription = "initial tip value and $billValueToTest as bill amount"
                assertTipPercent(caseDescription, tipToTest)
                assertBillValue(caseDescription, billValueToTest.toBigDecimal())
            }
        }
    }

    @Test
    fun test03_checkBothValueAndTipSetWithSeekBarSetLast() {
        testActivity {
            TipCalculatorScreen(this).apply {
                val billValueToTest = 201
                setBillAmount("$billValueToTest")

                val tipToTest = 10
                setTipPercent(tipToTest)

                val caseDescription =
                    "first bill is set to $billValueToTest and then tip is set to $tipToTest"
                assertTipPercent(caseDescription, tipToTest)
                assertBillValue(caseDescription, billValueToTest.toBigDecimal())
            }
        }
    }

    @Test
    fun test04_checkEditTextListenerLast() {
        testActivity {
            TipCalculatorScreen(this).apply {
                val billValueToTest = 39
                setBillAmount("$billValueToTest")

                val tipToTest = 90
                setTipPercent(tipToTest)

                val caseDescription =
                    "first tip is set to $tipToTest and then bill is set to $billValueToTest"
                assertTipPercent(caseDescription, tipToTest)
                assertBillValue(caseDescription, billValueToTest.toBigDecimal())
            }
        }
    }

    @Test
    fun test05_checkLargeValue() {
        testActivity {
            TipCalculatorScreen(this).apply {
                val messageLargeNumberTextError = "Make sure you give support for large numbers"

                try {
                    val billValueToTest = "100000000000000000000"
                    setBillAmount(billValueToTest)

                    val tipToTest = 90
                    setTipPercent(tipToTest)

                    val caseDescription =
                        "bill value is set to a large int value and tip is set to $tipToTest"
                    assertTipPercent(caseDescription, tipToTest)
                    assertBillValue(caseDescription, billValueToTest.toBigDecimal())

                } catch (ex: Exception) {
                    throw AssertionError(
                        "Exception thrown ${ex.javaClass.simpleName}. " +
                                messageLargeNumberTextError, ex
                    )
                }
            }
        }
    }

    @Test
    fun test06_checkDecimalValue() {
        testActivity {
            TipCalculatorScreen(this).apply {
                val billValueToTest = "70.12"
                setBillAmount(billValueToTest)

                val tipToTest = 50
                setTipPercent(tipToTest)

                val caseDescription =
                    "bill value is set to a decimal number and tip is set to $tipToTest"
                assertTipPercent(caseDescription, tipToTest)
                assertBillValue(caseDescription, billValueToTest.toBigDecimal())
            }
        }
    }

    @Test
    fun test07_checkClearingValue() {
        testActivity {
            TipCalculatorScreen(this).apply {
                setBillAmount("10.10")
                setBillAmount("")

                val caseDescription = "\"$idEditText\" has been cleared"
                assertTipPercentIsEmpty(caseDescription)
                assertBillValueIsEmpty(caseDescription)
            }
        }
    }

    @Test
    fun test08_checkZeroingValue() {
        testActivity {
            TipCalculatorScreen(this).apply {
                setBillAmount("10.10")
                setBillAmount("0.0")

                val caseDescription = "\"$idEditText\" has been zeroed"
                assertTipPercentIsEmpty(caseDescription)
                assertBillValueIsEmpty(caseDescription)
            }
        }
    }
}