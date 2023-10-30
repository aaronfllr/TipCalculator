package org.hyperskill.calculator.tip

import org.hyperskill.calculator.tip.internals.TipCalculatorUnitTest
import org.hyperskill.calculator.tip.internals.screen.TipCalculatorScreen
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner

// Version 3.0
@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Stage1UnitTest : TipCalculatorUnitTest<MainActivity>(MainActivity::class.java) {

    @Test
    fun test00_checkEditText() {
        testActivity {
            TipCalculatorScreen(this, initViews = false).apply {
                editText
            }
        }
    }

    @Test
    fun test01_checkSlider() {
        testActivity {
            TipCalculatorScreen(this, initViews = false).apply {
                seekBar
            }
        }
    }

    @Test
    fun test02_checkBillValueTextView() {
        testActivity {
            TipCalculatorScreen(this, initViews = false).apply {
                billValueTextView
            }
        }
    }

    @Test
    fun test03_checkTipPercentTextView() {
        testActivity {
            TipCalculatorScreen(this, initViews = false).apply {
                tipPercentTextView
            }
        }
    }

    @Test
    fun test04_checkTipAmountTextView() {
        testActivity {
            TipCalculatorScreen(this, initViews = false).apply {
                tipAmountTextView
            }
        }
    }
}