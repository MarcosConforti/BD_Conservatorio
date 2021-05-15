package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AcercaDe extends AppCompatActivity {
    private TextView tv1;
    String nombre;
    int numero = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        tv1 = (TextView)findViewById(R.id.tv_acercaDe);
        tv1.setText("Creado por Marcos");

        nombre = getIntent().getStringExtra("nombre");
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, Alumnos.class);
        intent.putExtra("nombre",nombre);
        intent.putExtra("numero", numero);
        startActivity(intent);
        finish();
    }
}