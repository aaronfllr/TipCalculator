package org.hyperskill.calculator.tip

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView
        setContentView(R.layout.activity_main)

        val editView: View? = findViewById(R.id.edit_text)
    }
}