package com.map_nsc.example.krutin_polra_assignment_1

import android.app.ActivityOptions
import android.os.Bundle
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imageView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Reference to the ImageView
        val imageView : ImageView = findViewById(R.id.imageView)
        val buttonGoToHomePage : Button = findViewById(R.id.btnGoToHomepage)

        buttonGoToHomePage.setOnClickListener {
            val goToRegistration : Intent = Intent(this, registration_activity::class.java)
            // Use ActivityOptions for custom animation
            val options = ActivityOptions.makeCustomAnimation(
                this,
                android.R.anim.fade_in, // Enter animation
                android.R.anim.fade_out // Exit animation
            )
            startActivity(goToRegistration, options.toBundle())
        }

        // Load the animation
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)

        // Start the animation
        imageView.startAnimation(fadeInAnimation)
        buttonGoToHomePage.startAnimation(scaleAnimation)

    }

}