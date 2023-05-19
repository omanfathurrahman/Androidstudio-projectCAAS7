package com.example.caas7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth

class LogoutActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient : GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        auth = FirebaseAuth.getInstance()

        val displayName = intent.getStringExtra("displayName")

        findViewById<TextView>(R.id.tvNameProfile).text = displayName

        findViewById<AppCompatButton>(R.id.gSignOutBtn).setOnClickListener {
            signOut()
        }

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
        findViewById<ImageButton>(R.id.imbNews).setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            intent.putExtra("displayName", displayName)
            startActivity(intent)
        }
    }
    private fun signOut() {
        // Logout dari Firebase Authentication
        auth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }



}