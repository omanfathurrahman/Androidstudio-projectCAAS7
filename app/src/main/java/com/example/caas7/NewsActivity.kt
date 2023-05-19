package com.example.caas7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth

class NewsActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        auth = FirebaseAuth.getInstance()

        val displayName = intent.getStringExtra("displayName")

        findViewById<TextView>(R.id.tvNameNews).text = displayName

        findViewById<ImageButton>(R.id.imbMain).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("displayName", displayName)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.imbProfil).setOnClickListener {
            val intent = Intent(this, LogoutActivity::class.java)
            intent.putExtra("displayName", displayName)
            startActivity(intent)
        }
    }
}