package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText et_nombre, et_pass, et_instrumento, et_documento, et_apellido;
    private RadioButton rb_alumno, rb_docente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        et_nombre = (EditText)findViewById(R.id.txt_nombreRegistro);
        et_pass = (EditText)findViewById(R.id.txt_passRegistro);
        et_instrumento = (EditText)findViewById(R.id.txt_instrumentoRegistro);
        et_apellido = (EditText)findViewById(R.id.txt_apellido);
        et_documento = (EditText)findViewById(R.id.txt_documento);
        rb_alumno = (RadioButton)findViewById(R.id.rb_alumno);
        rb_docente = (RadioButton)findViewById(R.id.rb_docente);
    }

    public void Registrar(View view) {
        String nombre = et_nombre.getText().toString();
        String pass = et_pass.getText().toString();
        String apellido = et_apellido.getText().toString();
        String instrumento = et_instrumento.getText().toString();
        String documento = et_documento.getText().toString();
        int documento_int = Integer.parseInt(documento);
        if(rb_alumno.isChecked() == true && !nombre.isEmpty() && !pass.isEmpty() && !instrumento.isEmpty()){
            String categoria = "alumno";
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"usuarios",null,1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("pass", pass);
            registro.put("apellido", apellido);
            registro.put("documento", documento_int);
            registro.put("instrumento", instrumento);
            registro.put("categoria",categoria);
            BaseDeDatos.insert("usuarios", null,registro);
            Toast.makeText(this, "Registro Alumno exitoso", Toast.LENGTH_SHORT).show();
            BaseDeDatos.close();
        }else if(rb_docente.isChecked() == true && !nombre.isEmpty() && !pass.isEmpty() && !instrumento.isEmpty()){
            String categoria = "docente";
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null,1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("apellido",apellido);
            registro.put("documento", documento);
            registro.put("pass", pass);
            registro.put("instrumento", instrumento);
            registro.put("categoria", categoria);
            BaseDeDatos.insert("usuarios",null, registro);
            Toast.makeText(this, "Registro Docente exitoso", Toast.LENGTH_SHORT).show();
            BaseDeDatos.close();
        }
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed(){

    }
}