package com.example.caas7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class AccountActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        auth = FirebaseAuth.getInstance()

        val displayName = intent.getStringExtra("name")

        findViewById<TextView>(R.id.textUser).text = displayName

        findViewById<Button>(R.id.continueBtn).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("displayName", displayName)
            startActivity(intent)
            finish()
        }

    }
}