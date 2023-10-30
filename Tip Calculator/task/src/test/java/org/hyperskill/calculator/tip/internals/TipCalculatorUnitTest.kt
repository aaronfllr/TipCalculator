package org.hyperskill.calculator.tip.internals

import android.app.Activity
import android.widget.SeekBar
import android.widget.TextView
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

// Version 3.0
open class TipCalculatorUnitTest<T : Activity>(clazz: Class<T>) : AbstractUnitTest<T>(clazz) {

    internal fun SeekBar.assertSeekbarInitialValues(
        idString: String,
        expectedMinProgress: Int,
        expectedMaxProgress: Int,
        expectedProgress: Int
    ) {

        val messageValueToError =
            "View \"$idString\" should have required max attribute"
        val actualValueTo = max
        assertEquals(messageValueToError, expectedMaxProgress, actualValueTo)

        val messageValueError =
            "View \"$idString\" should have proper initial value for attribute progress"
        val actualValue = progress
        assertEquals(messageValueError, expectedProgress, actualValue)

        val messageValueFromError =
            "On View \"$idString\" keep the value of min attribute set to 0"
        val actualValueFrom = min
        assertEquals(messageValueFromError, expectedMinProgress, actualValueFrom)
    }
    internal fun assertTextViewText(
        caseDescription: String, expectedText: String, idString: String, textView: TextView) {

        val messageTextError =
            "When $caseDescription then View with id \"$idString\" should have text"
        val actualText = textView.text
        assertEquals(messageTextError, expectedText, actualText)
    }

    internal fun assertTextViewIsEmpty(caseDescription: String, idString: String, textView: TextView) {
        val messageTextNotEmptyError =
            "When $caseDescription View with id \"$idString\" should be empty"
        val isBillEmpty = textView.text.isNullOrEmpty()
        assertTrue(messageTextNotEmptyError, isBillEmpty)
    }
}