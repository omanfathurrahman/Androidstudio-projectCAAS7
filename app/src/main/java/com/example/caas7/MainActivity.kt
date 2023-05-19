package com.example.caas7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val displayName = intent.getStringExtra("displayName")

        findViewById<TextView>(R.id.tvNameHome).text = displayName

        findViewById<ImageButton>(R.id.imbProfil).setOnClickListener {
            val intent = Intent(this, LogoutActivity::class.java)
            intent.putExtra("displayName", displayName)
            startActivity(intent)
        }
        findViewById<ImageButton>(R.id.imbNews).setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            intent.putExtra("displayName", displayName)
            startActivity(intent)
        }
    }
}