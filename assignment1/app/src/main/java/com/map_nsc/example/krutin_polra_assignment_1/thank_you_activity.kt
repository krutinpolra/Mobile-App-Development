package com.map_nsc.example.krutin_polra_assignment_1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class thank_you_activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thank_you)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val receivedFName : String? = intent.getStringExtra("FIRST_NAME");
        val receivedLName : String? = intent.getStringExtra("LAST_NAME");
        val receivedEMail: String? = intent.getStringExtra("EMAIL");

        val tvMessage : TextView = findViewById(R.id.tvMessage);
        val mail : TextView = findViewById(R.id.displayMail)
        tvMessage.text = "Thanks for registering, $receivedFName $receivedLName!";
        mail.text = "E-Mail: $receivedEMail"
    }
}