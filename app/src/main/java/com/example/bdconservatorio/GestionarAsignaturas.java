package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GestionarAsignaturas extends AppCompatActivity {

    private EditText et_registrar;
    private TextView tv_mostrar;
    String dato, nombre;
    //String [] listaMaterias= new String[]{"historia", "lenguaje musical", "instrumento"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_asignaturas);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        nombre = getIntent().getStringExtra("nombre");

        /*for(int i = 0; i<listaMaterias.length; i++){
            dato = listaMaterias[i];
        }*/

        et_registrar = (EditText)findViewById(R.id.txt_registrarAsignatura);
        tv_mostrar = (TextView)findViewById(R.id.tv_materiaRegistrada);
    }


    public void RegistrarAsignatura(View view) {
        dato = et_registrar.getText().toString();
        if(!dato.isEmpty()) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "asignaturas", null, 1);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("materias", dato);
            BaseDeDatos.insert("asignaturas", null, registro);
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            BaseDeDatos.close();
            et_registrar.setText("");
        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    public void Consulta(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "asignaturas", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("SELECT materias FROM asignaturas",null);
        if(fila.moveToFirst()) {
            tv_mostrar.setText(fila.getString(0));
        }else{
            Toast.makeText(this, "Error en la consulta", Toast.LENGTH_SHORT).show();
        }
        fila.close();
        BaseDeDatos.close();
    }
    public void onBackPressed(){
        Intent intent = new Intent(this, Alumnos.class);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
        finish();
    }
}