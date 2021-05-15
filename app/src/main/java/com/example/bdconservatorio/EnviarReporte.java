package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EnviarReporte extends AppCompatActivity {

    private EditText et_reporte;
    String reporte, nombre;
    int numero = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_reporte);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        et_reporte = (EditText)findViewById(R.id.txt_reporte);
        reporte = et_reporte.getText().toString();

        nombre = getIntent().getStringExtra("nombre");
    }

    public void EnviarReporte(View view) {
        if(!reporte.isEmpty()){

        }else{
            Toast.makeText(this, "Debes llenar el reporte", Toast.LENGTH_SHORT).show();
        }
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