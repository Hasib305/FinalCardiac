package com.example.cardiacrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

/**
 * The SplashActivity class represents the splash screen of the application.
 * It is displayed for a certain duration and then transitions to the LoginActivity.
 */
public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the splashImageView with the ImageView from the layout file
        ImageView splashImageView = findViewById(R.id.splashImageView);

        // Load the animated GIF into the splashImageView using Glide library
        Glide.with(this)
                .asGif()
                .load(R.raw.hr)
                .into(splashImageView);

        // Create a new Handler to post a delayed action
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start the LoginActivity
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish the SplashActivity to prevent going back to it
            }
        }, SPLASH_DELAY);
    }
}
