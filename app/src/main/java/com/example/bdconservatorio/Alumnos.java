package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Alumnos extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1, tv2, tv3, tv4, tv5,tv6,tv7;
    private ImageButton ib1, ib2, ib3, ib4, ib5,ib6,ib7;
    String nombre, nombreRerporte, nombreAcercaDe,nombreConfiguracion,nombreCalendario,nombreAsignaturas;
    int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        tv1 = (TextView)findViewById(R.id.tv_infoUsuario);
        tv2 = (TextView)findViewById(R.id.tv_materias);
        tv3 = (TextView)findViewById(R.id.tv_calendario);
        tv4 = (TextView)findViewById(R.id.tv_acercaDe);
        tv5 = (TextView)findViewById(R.id.tv_enviarReporte);
        tv6 = (TextView)findViewById(R.id.tv_configuracion);
        tv7 = (TextView)findViewById(R.id.tv_cerrarSesion);

        ib1 = (ImageButton)findViewById(R.id.imageButton_fotoUsuario);
        ib2 = (ImageButton)findViewById(R.id.imageButton_Asignaturas);
        ib3 = (ImageButton)findViewById(R.id.imageButton_Calendario);
        ib4 = (ImageButton)findViewById(R.id.imageButton_AcercaDe);
        ib5 = (ImageButton)findViewById(R.id.imageButton_EnviarReporte);
        ib6 = (ImageButton)findViewById(R.id.imageButton_Configuracion);
        ib7 = (ImageButton)findViewById(R.id.imageButton_CerrarSesion);


        nombre = getIntent().getStringExtra("nombre");
        tv1.setText("Sesion de: " +nombre);

        Datos();

        tv2.setText("Materias");
        tv3.setText("Calendario");

        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.imageButton_fotoUsuario:
                Intent usuario = new Intent(this,InformacionUsuario.class);
                usuario.putExtra("nombre", nombre);
                startActivity(usuario);
                finish();
                break;
            case R.id.imageButton_Asignaturas:
                Intent materias = new Intent(this, Asignaturas.class);
                materias.putExtra("nombre", nombre);
                startActivity(materias);
                finish();
                break;
            case R.id.imageButton_Calendario:
                Intent calendario = new Intent(this, Calendario.class);
                calendario.putExtra("nombre",nombre);
                startActivity(calendario);
                finish();
                break;
            case R.id.imageButton_AcercaDe:
                Intent acercaDe = new Intent(this, AcercaDe.class);
                acercaDe.putExtra("nombre",nombre);
                startActivity(acercaDe);
                finish();
                break;
            case R.id.imageButton_EnviarReporte:
                Intent reporte = new Intent(this, EnviarReporte.class);
                reporte.putExtra("nombre",nombre);
                startActivity(reporte);
                finish();
                break;
            case  R.id.imageButton_Configuracion:
                Intent configuracion = new Intent(this,Configuracion.class);
                configuracion.putExtra("nombre",nombre);
                startActivity(configuracion);
                finish();
                break;
            case  R.id.imageButton_CerrarSesion:
                Intent cerrarSesion = new Intent(this, GestionarAsignaturas.class);
                cerrarSesion.putExtra("nombre", nombre);
                startActivity(cerrarSesion);
                finish();
                break;
        }

    }
    @Override
    public void onBackPressed(){

    }
    public void Datos(){
        numero = getIntent().getIntExtra("numero",numero);
        if(numero == 1) {
            nombreAsignaturas = getIntent().getStringExtra("nombre");
            tv1.setText("Sesion de: " + nombre);
        }else if (numero == 2) {
            nombreCalendario = getIntent().getStringExtra("nombre");
            tv1.setText("Sesion de: " + nombre);
        }else if(numero == 3) {
            nombreAcercaDe = getIntent().getStringExtra("nombre");
            tv1.setText("Sesion de: " + nombre);
        }else if(numero == 4) {
            nombreRerporte = getIntent().getStringExtra("nombre");
            tv1.setText("Sesion de: " + nombre);
        }else if(numero == 5) {
            nombreConfiguracion = getIntent().getStringExtra("nombre");
            tv1.setText("Sesion de: " + nombre);
        }
    }
}