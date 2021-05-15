package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText txt_nombre,txt_pass;
    //private ImageButton ib_musicOn, ib_musicOff;
    //private MediaPlayer mp_bach, mp_mozart, mp_vivaldi,mp_mussogrsky;
    String nombre,pass,documento,apellido,instrumento,categoria;
    /*int numAleatorio = (int) (Math.random() *3);
    int contador = 0;
    boolean botonMusica = false;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_nombre = (EditText)findViewById(R.id.txt_nombreUsuario);
        txt_pass = (EditText)findViewById(R.id.txt_passUsuario);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

       /* ib_musicOn = (ImageButton)findViewById(R.id.imageButton_musicaOn);
        ib_musicOff = (ImageButton)findViewById(R.id.imageButton_musicaOff);

        mp_bach = MediaPlayer.create(this, R.raw.bach);
        mp_mozart = MediaPlayer.create(this, R.raw.mozart);
        mp_vivaldi = MediaPlayer.create(this, R.raw.vivaldi);
        mp_mussogrsky = MediaPlayer.create(this, R.raw.mussorgsky);

        if(numAleatorio == 0){
            mp_bach.start();
        }else if(numAleatorio == 1){
            mp_mozart.start();
        }else if(numAleatorio == 2){
            mp_vivaldi.start();
        }else if(numAleatorio == 3){
            mp_mussogrsky.start();
        }*/

    }

    public void Registrar(View view) {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
        finish();
    }

    public void IniciarSesion(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"usuarios",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        nombre = txt_nombre.getText().toString();
        pass = txt_pass.getText().toString();

        if(!nombre.isEmpty() && !pass.isEmpty()) {
            Cursor fila = BaseDeDatos.rawQuery("SELECT nombre, pass, categoria FROM usuarios WHERE nombre = " + "'" + nombre + "'" +" and pass = " + "'" + pass + "'",null);
            if(fila.moveToFirst()) {
                txt_nombre.setText(fila.getString(0));
                txt_pass.setText(fila.getString(1));
                categoria = (fila.getString(2));
                if(categoria.equals("alumno")){
                Intent intent = new Intent(this, Alumnos.class);
                intent.putExtra("nombre", nombre);
                startActivity(intent);
                finish();
                }else if (categoria.equals("docente")){
                    Intent intent = new Intent(this, Maestros.class);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                    finish();
                }
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
          }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    public void SilenciarMusica(View view){
        /*switch(view.getId()){
            case R.id.imageButton_musicaOn:
                ib_musicOff.setVisibility(View.VISIBLE);
                ib_musicOn.setVisibility(View.INVISIBLE);
                if(numAleatorio == 0){
                    mp_bach.stop();
                }else if(numAleatorio == 1){
                    mp_mozart.stop();
                }else if(numAleatorio == 2){
                    mp_vivaldi.stop();
                }else if(numAleatorio == 3){
                    mp_mussogrsky.stop();
                }
                break;
            case  R.id.imageButton_musicaOff:
                ib_musicOn.setVisibility(View.VISIBLE);
                ib_musicOff.setVisibility(View.INVISIBLE);
                if (numAleatorio == 0) {
                    mp_bach.start();
                } else if (numAleatorio == 1) {
                    mp_mozart.start();
                } else if (numAleatorio == 2) {
                    mp_vivaldi.start();
                } else if (numAleatorio == 3) {
                    mp_mussogrsky.start();
                }
                break;
        }*/
        /*botonMusica = true;
        if(contador == 0) {
               ib_musicOff.setVisibility(View.VISIBLE);
               ib_musicOn.setVisibility(View.INVISIBLE);
               if(numAleatorio == 0){
                   mp_bach.stop();
               }else if(numAleatorio == 1){
                   mp_mozart.stop();
               }else if(numAleatorio == 2){
                   mp_vivaldi.stop();
               }else if(numAleatorio == 3){
                   mp_mussogrsky.stop();
               }
        }else if(contador == 1) {
            ib_musicOn.setVisibility(View.VISIBLE);
            ib_musicOff.setVisibility(View.INVISIBLE);
            if (numAleatorio == 0) {
                mp_bach.start();
            } else if (numAleatorio == 1) {
                mp_mozart.start();
            } else if (numAleatorio == 2) {
                mp_vivaldi.start();
            } else if (numAleatorio == 3) {
                mp_mussogrsky.start();
            }
        }
        if(botonMusica == true) {
            if (contador == 0) {
                contador = 1;
            } else {
                contador = 0;
            }
        }*/
    }
}