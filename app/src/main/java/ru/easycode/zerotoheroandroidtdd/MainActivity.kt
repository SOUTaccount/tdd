package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    private lateinit var title: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById<TextView>(R.id.titleTextView)

        title.text = ViewModelStub.textTitle
        button = findViewById(R.id.changeButton)

        button.setOnClickListener {
            title.text = "I am an Android Developer!"
        }
    }

    override fun onStop() {
        super.onStop()
        ViewModelStub.textTitle = title.text.toString()
    }
}