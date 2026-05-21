package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    private lateinit var title: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById<TextView>(R.id.countTextView)

        title.text = ViewModelStub.count.toString()
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            ViewModelStub.count += 2
            title.text = ViewModelStub.count.toString()
        }
    }
}