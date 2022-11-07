package com.example.myproyectpocketsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myproyectpocketsave.menuHome.GastosFragment;

public class AgregarMovimiento extends AppCompatActivity {
    Button btn_regresar, btn_guardarMovimiento;
    Spinner lista;
    String datos[] = {"Seleccionar tipo de Movimiento","Ingreso", "Egreso"};
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_movimiento);

        //Inicialización de botones:
        btn_guardarMovimiento = (Button) findViewById(R.id.btn_guardarMovimiento);
        btn_regresar = (Button) findViewById(R.id.btn_regresar);

        lista = (Spinner) findViewById(R.id.listaMov);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, datos);
        lista.setAdapter(arrayAdapter);

        // Método para definir las opciones seleccionadas
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        Toast.makeText(AgregarMovimiento.this, datos[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(AgregarMovimiento.this, datos[position], Toast.LENGTH_SHORT).show();
                        break;
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Metodo click del botón regresar
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( AgregarMovimiento.this, GastosFragment.class);
                startActivity(intent);
            }
        });
    }
}