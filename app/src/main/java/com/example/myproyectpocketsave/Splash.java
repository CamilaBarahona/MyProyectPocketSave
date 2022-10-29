package com.example.myproyectpocketsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    private int tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tiempo = 4000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent( Splash.this, MainActivity.class));
                finish();
            }
        } , tiempo);
    }
}