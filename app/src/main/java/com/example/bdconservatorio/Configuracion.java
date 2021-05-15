package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity {

    private TextView tv1,tv2,tv3;
    private Spinner sp1,sp2,sp3;
    String nombre;
    int numero = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        tv1 = (TextView)findViewById(R.id.tv_tamanioLetra);
        tv2 = (TextView)findViewById(R.id.tv_cambiarColor);
        tv3 = (TextView)findViewById(R.id.tv_cambiarMusica);

        sp1 = (Spinner)findViewById(R.id.spinner_letra);
        sp2 = (Spinner)findViewById(R.id.spinner_color);
        sp3 = (Spinner)findViewById(R.id.spinner_musica);

        nombre = getIntent().getStringExtra("nombre");

        String [] spLetra = {"Grande", "Mediano", "Chico"};
        String [] spColor = {"Rojo","Verde","Azul"};
        String [] spMusica = {"Vivaldi","Bach","Mozart"};

        ArrayAdapter <String> adapterLetra = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spLetra);
        sp1.setAdapter(adapterLetra);
        ArrayAdapter <String> adapterColor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spColor);
        sp2.setAdapter(adapterColor);
        ArrayAdapter <String> adapterMusica = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spMusica);
        sp3.setAdapter(adapterMusica);
    }

    public void GuardarCambios(View view) {
        Toast.makeText(this, "Se han guardado los Cambios", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,Alumnos.class);
        intent.putExtra("nombre",nombre);
        intent.putExtra("numero",numero);
        startActivity(intent);
        finish();
    }
}