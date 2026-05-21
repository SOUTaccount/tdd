package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var titleTextView: TextView
    private lateinit var actionButton: Button

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        titleTextView = findViewById(R.id.titleTextView)
        actionButton = findViewById(R.id.actionButton)

        actionButton.setOnClickListener {
            loadData()
        }
    }

    private fun loadData() {
        progressBar.visibility = android.view.View.VISIBLE
        actionButton.isEnabled = false
        titleTextView.visibility = android.view.View.GONE

        handler.postDelayed({
            progressBar.visibility = android.view.View.GONE
            titleTextView.text = "Data loaded successfully"
            titleTextView.visibility = android.view.View.VISIBLE
            actionButton.isEnabled = true
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}