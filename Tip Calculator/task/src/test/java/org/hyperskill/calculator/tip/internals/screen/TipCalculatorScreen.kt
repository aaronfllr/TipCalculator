package org.hyperskill.calculator.tip.internals.screen

import android.text.InputType
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import org.hyperskill.calculator.tip.MainActivity
import org.hyperskill.calculator.tip.internals.TipCalculatorUnitTest
import org.junit.Assert.assertEquals
import java.math.BigDecimal
import java.util.concurrent.TimeUnit

// Version 3.0
class TipCalculatorScreen(
    private val test: TipCalculatorUnitTest<MainActivity>, initViews: Boolean = true) {

    companion object {
        const val idEditText = "edit_text"
        const val idSeekBar = "seek_bar"
        const val idBillValueTextView = "bill_value_tv"
        const val idTipPercentTextView = "tip_percent_tv"
        const val idTipAmountTextView = "tip_amount_tv"

        const val formatTipPercent = "Tip: %d%%"
        const val formatBillValue = "Bill Value: $%.2f"
        const val formatTipAmount = "Tip Amount: $%s"
    }

    val editText by lazy  {
        with(test) {
            activity.findViewByString<EditText>(idEditText).apply {
                val messageInputTypeError = "View \"$idEditText\" should have inputType number"
                val expectedInputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
                val actualInputType = inputType
                assertEquals(messageInputTypeError, expectedInputType, actualInputType)

                val messageHintError = "View \"$idEditText\" should have hint"
                val expectedHint = "Insert Bill Value"
                val actualHint = hint
                assertEquals(messageHintError, expectedHint, actualHint)
            }
        }
    }

    val seekBar by lazy  {
        with(test) {
            activity.findViewByString<SeekBar>(idSeekBar).apply {
                assertSeekbarInitialValues(
                    idString = idSeekBar,
                    expectedMinProgress = 0,
                    expectedMaxProgress = 100,
                    expectedProgress = 15
                )
            }
        }
    }

    val billValueTextView by lazy  {
        with(test) {
            activity.findViewByString<TextView>(idBillValueTextView).apply {
                val messageInitialTextError =
                    "View \"$idBillValueTextView\" should initially have empty text"
                val expectedInitialText = ""
                val actualInitialText = text.toString()
                assertEquals(messageInitialTextError, expectedInitialText, actualInitialText)
            }
        }
    }

    val tipPercentTextView by lazy  {
        with(test) {
            activity.findViewByString<TextView>(idTipPercentTextView).apply {
                val messageInitialTextError =
                    "View \"$idTipPercentTextView\" should initially have empty text"
                val expectedInitialText = ""
                val actualInitialText = text.toString()
                assertEquals(messageInitialTextError, expectedInitialText, actualInitialText)
            }
        }

    }

    val tipAmountTextView by lazy  {
        with(test) {
            activity.findViewByString<TextView>(idTipAmountTextView).apply {
                val messageInitialTextError =
                    "View \"$idTipAmountTextView\" should initially have empty text"
                val expectedInitialText = ""
                val actualInitialText = text.toString()
                assertEquals(messageInitialTextError, expectedInitialText, actualInitialText)
            }
        }
    }

    init {
        if(initViews) {
            editText
            tipPercentTextView
            billValueTextView
            tipAmountTextView
            seekBar
        }
    }

    fun setTipPercent(tipPercent: Int) = with(test) {
        seekBar.setProgressAsUser(tipPercent)
    }

    fun setBillAmount(billAmount: String) = with(test) {
        editText.setText(billAmount)
        shadowLooper.idleFor(500L, TimeUnit.MILLISECONDS)
    }

    fun assertTipPercentIsEmpty(caseDescription: String) = with(test) {
        assertTextViewIsEmpty(caseDescription,
            idTipPercentTextView, tipPercentTextView)
    }

    fun assertBillValueIsEmpty(caseDescription: String) = with(test) {
        assertTextViewIsEmpty(caseDescription,
            idBillValueTextView, billValueTextView)
    }

    fun asserTipAmountIsEmpty(caseDescription: String) = with(test) {
        assertTextViewIsEmpty(caseDescription,
            idTipAmountTextView, tipAmountTextView)
    }

    fun assertTipPercent(caseDescription: String, tipPercent: Int) = with(test) {
        val expectedTipPercentText = formatTipPercent.format(tipPercent)
        assertTextViewText(
            caseDescription = caseDescription,
            expectedText = expectedTipPercentText,
            idString = idTipPercentTextView,
            textView = tipPercentTextView
        )
    }

    fun assertBillValue(caseDescription: String, billValue: BigDecimal) = with(test) {
        val expectedBillValueText = formatBillValue.format(billValue)
        assertTextViewText(
            caseDescription = caseDescription,
            expectedText = expectedBillValueText,
            idString = idBillValueTextView,
            textView = billValueTextView
        )
    }

    fun assertTipAmount(caseDescription: String, tipAmount: String) = with(test) {
        val expectedTipAmountText = formatTipAmount.format(tipAmount)
        assertTextViewText(
            caseDescription = caseDescription,
            expectedText =  expectedTipAmountText,
            idString = idTipAmountTextView,
            textView = tipAmountTextView
        )
    }
}