package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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

        title = findViewById<TextView>(R.id.titleTextView)

        title.text = ViewModelStub.textTitle
        title.visibility = if (ViewModelStub.titleVisible) VISIBLE else GONE
        button = findViewById(R.id.hideButton)

        button.setOnClickListener {
            title.text = "I am an Android Developer!"
            title.visibility = GONE
        }
    }

    override fun onStop() {
        super.onStop()
        ViewModelStub.textTitle = title.text.toString()
        ViewModelStub.titleVisible = title.isVisible
    }
}