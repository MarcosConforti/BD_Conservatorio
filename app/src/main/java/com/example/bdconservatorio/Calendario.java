package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

public class Calendario extends AppCompatActivity {

    private CalendarView calendario;
    String nombre;
    int numero = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        calendario = (CalendarView)findViewById(R.id.calendarView);

        nombre = getIntent().getStringExtra("nombre");
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, Alumnos.class);
        intent.putExtra("nombre",nombre);
        intent.putExtra("numero",numero);
        startActivity(intent);
        finish();
    }
}