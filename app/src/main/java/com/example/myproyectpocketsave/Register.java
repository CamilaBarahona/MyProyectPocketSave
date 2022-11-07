package com.example.myproyectpocketsave;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myproyectpocketsave.Database.Leer;

import java.util.Date;

public class Register extends AppCompatActivity {
    private Button btn_validar, btn_ver;
    private EditText ed_rut, ed_nombre, ed_apelPat, ed_apelMat, ed_direccion, ed_fechaNac, ed_email, ed_pass;
    private RadioGroup rb_genero;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_validar = (Button) findViewById(R.id.btn_validar);
        btn_ver = (Button) findViewById(R.id.btn_ver);

        ed_rut = (EditText) findViewById(R.id.ed_rut);
        ed_nombre = (EditText) findViewById(R.id.ed_nombre);
        ed_apelPat = (EditText) findViewById(R.id.ed_apellido_paterno);
        ed_apelMat = (EditText) findViewById(R.id.ed_apellido_materno);
        ed_direccion = (EditText) findViewById(R.id.ed_direccion);
        ed_fechaNac = (EditText) findViewById(R.id.ed_fechaNac);
        ed_email = (EditText) findViewById(R.id.ed_email);
        ed_pass = (EditText) findViewById(R.id.ed_password);

        rb_genero = (RadioGroup) findViewById(R.id.rgGenero);



        btn_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar();
                /*
                Toast.makeText(Register.this, "Usuario Creado con éxito", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(
                        Register.this, Login.class
                ));

                 */
            }

        });

        btn_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        getApplicationContext(), Leer.class
                ));
            }
        });
    }

    public void insertar() {
        try {
             String rut = ed_rut.getText().toString();
             String name = ed_nombre.getText().toString();
             String lastPatern = ed_apelPat.getText().toString();
             String lastMatern = ed_apelMat.getText().toString();
             String birthDate = ed_fechaNac.getText().toString();
             String adress = ed_direccion.getText().toString();
             String email = ed_email.getText().toString();
             String password = ed_pass.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("BD_POCKETSAVE", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, rut VARCHAR, name VARCHAR, lastPatern VARCHAR, lastMatern VARCHAR, birthDate VARCHAR, adress VARCHAR, email VARCHAR, password VARCHAR)");
            String sql = "insert into usuario(rut,name,lastPatern,lastMatern,birthDate,adress,email,password)values(?,?,?,?,?,?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,rut);
            statement.bindString(2,name);
            statement.bindString(3,lastPatern);
            statement.bindString(4, lastMatern);
            statement.bindString(5,birthDate);
            statement.bindString(6,adress);
            statement.bindString(7,email);
            statement.bindString(8,password);
            statement.execute();
            Toast.makeText(this, "Usuario registrado con éxito en la base de datos", Toast.LENGTH_LONG).show();

            ed_rut.setText("");
            ed_nombre.setText("");
            ed_apelPat.setText("");
            ed_apelMat.setText("");
            ed_direccion.setText("");
            ed_fechaNac.setText("");
            ed_email.setText("");
            ed_pass.setText("");
            ed_rut.requestFocus();
        }
        catch(Exception ex) {
            Toast.makeText(this, "Error en el registro del usuario", Toast.LENGTH_LONG).show();
        }
    }
}