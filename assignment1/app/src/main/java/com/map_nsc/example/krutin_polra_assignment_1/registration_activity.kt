package com.map_nsc.example.krutin_polra_assignment_1

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class registration_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstName : EditText = findViewById(R.id.etFirstName);
        val lastName : EditText = findViewById(R.id.etLastName);
        val mail : EditText = findViewById(R.id.etEmail);
        val registerButton : Button = findViewById(R.id.btnRegister);

        registerButton.setOnClickListener {

            val fName = firstName.text.toString().trim();
            val lName = lastName.text.toString().trim();
            val email = mail.text.toString().trim();

            if (fName.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Please provide your First Name",
                    Toast.LENGTH_SHORT
                ).show()
            }else if (lName.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Please provide your Last Name",
                    Toast.LENGTH_SHORT
                ).show()
            }else if (email.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Please provide your Email",
                    Toast.LENGTH_SHORT
                ).show()
            }else if (fName.isEmpty() && lName.isEmpty() && email.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "First Name, Last Name, end Email required",
                    Toast.LENGTH_SHORT
                ).show()
            } else{
                val goToRegistration = Intent(this, thank_you_activity::class.java)
                // Use ActivityOptions for custom animation
                val options = ActivityOptions.makeCustomAnimation(
                    this,
                    android.R.anim.fade_in, // Enter animation
                    android.R.anim.fade_out // Exit animation
                )

                goToRegistration.putExtra("FIRST_NAME", fName);
                goToRegistration.putExtra("LAST_NAME", lName);
                goToRegistration.putExtra("EMAIL", email);
                startActivity(goToRegistration, options.toBundle());
            }
        }


    }
}