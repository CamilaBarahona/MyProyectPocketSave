package com.example.myproyectpocketsave.Database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myproyectpocketsave.R;

import java.util.ArrayList;

public class Leer extends AppCompatActivity {

    private ListView lista1;
    private ArrayList<String> arreglo = new ArrayList<String>();
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer);

        try {
            SQLiteDatabase db = openOrCreateDatabase("BD_POCKETSAVE", Context.MODE_PRIVATE, null);
            lista1 = findViewById(R.id.lista1);
            final Cursor c = db.rawQuery("select * from usuario", null);
            int id = c.getColumnIndex("Id");
            int rut = c.getColumnIndex("Rut");
            int name = c.getColumnIndex("Nombre");
            int lastPatern = c.getColumnIndex("Apellido Paterno");
            int lastMatern = c.getColumnIndex("Apellido Materno");
            int birthDate = c.getColumnIndex("Fecha de Nacimiento");
            int adress = c.getColumnIndex("Dirección");
            int email = c.getColumnIndex("Correo");
            int password = c.getColumnIndex("Password");
            arreglo.clear();

            arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arreglo);
            lista1.setAdapter(arrayAdapter);

            final ArrayList<Usuario> lista = new ArrayList<>();

            if (c.moveToFirst()) {
                do {
                    Usuario usuario = new Usuario();
                    usuario.id = c.getString(id);
                    usuario.rut = c.getString(rut);
                    usuario.name = c.getString(name);
                    usuario.lastPatern = c.getString(lastPatern);
                    usuario.lastMatern = c.getString(lastMatern);
                    usuario.birthDate = c.getString(birthDate);
                    usuario.adress = c.getString(adress);
                    usuario.email = c.getString(email);
                    usuario.password = c.getString(password);
                    lista.add(usuario);

                    arreglo.add(c.getString(id) +" \t "+ c.getString(rut)+ " \t "+ c.getString(name)+ " \t " + c.getString(lastPatern)+ " \t " + c.getString(lastMatern)+ " \t " +c.getString(birthDate)+ " \t " + c.getString(adress)+ " \t " + c.getString(email)+ " \t " + c.getString(password));                    arreglo.add(c.getString(id) +" \t "+ c.getString(rut)+ " \t "+ c.getString(name)+ " \t " + c.getString(lastPatern)+ " \t " + c.getString(lastMatern)+ " \t " +c.getString(birthDate)+ " \t " + c.getString(adress)+ " \t " + c.getString(email));
                } while (c.moveToNext());
                arrayAdapter.notifyDataSetChanged();
                lista1.invalidateViews();
            }
            lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Usuario usuario = lista.get(position);
                    /*Intent i = new Intent(getApplicationContext(), Editar.class);
                    i.putExtra("id", usuario.id);
                    i.putExtra("rut", usuario.rut);
                    i.putExtra("name", usuario.name);
                    i.putExtra("lastPatern", usuario.lastPatern);
                    i.putExtra("lastMatern", usuario.lastMatern);
                    i.putExtra("birthDate", usuario.birthDate);
                    i.putExtra("adress", usuario.adress);
                    i.putExtra("email", usuario.email);
                    i.putExtra("pass", usuario.password);
                    startActivity(i);*/
                }
            });
        }
        catch (Exception e) {
            Toast.makeText(this, "Ha ocurrido un error, inténtalo nuevamente.", Toast.LENGTH_SHORT).show();
        }

    }
}