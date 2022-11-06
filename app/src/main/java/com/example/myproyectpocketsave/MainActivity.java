package com.example.myproyectpocketsave;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myproyectpocketsave.Sensores.Sensores;

public class MainActivity extends AppCompatActivity {
    Button btn_registrarse, btn_iniciarSesion, btn_sensores;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_iniciarSesion = (Button) findViewById(R.id.btn_iniciarSesion);
        btn_registrarse = (Button) findViewById(R.id.btn_registrarse);
        btn_sensores = (Button) findViewById(R.id.btn_sensores);

        btn_iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        MainActivity.this, Login.class
                ));
            }
        });

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        MainActivity.this, Register.class
                ));
            }
        });
        btn_sensores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Sensores.class));
            }
        });
    }
}