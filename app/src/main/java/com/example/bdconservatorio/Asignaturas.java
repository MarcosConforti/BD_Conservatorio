package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Asignaturas extends AppCompatActivity {

    private TextView tv1, tv2;
    private ListView lv;
    //private String asignatuas[] = {};
    String nombre;
    int numero = 1;
    //int id_asignatura;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        tv1 = (TextView)findViewById(R.id.tv_usuario);
        tv2 = (TextView)findViewById(R.id.tv_asignatura);
        lv = (ListView)findViewById(R.id.lv_asignaturas);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item_marcos);

        nombre = getIntent().getStringExtra("nombre");
        tv1.setText("Sesion de: " + nombre);

        ConsultaAsignaturas();

    }
    public void ConsultaAsignaturas(){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "asignaturas", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("SELECT * FROM asignaturas",null);
        if(fila.moveToFirst()) {
                adapter.add(fila.getString(0));
            lv.setAdapter(adapter);
            BaseDeDatos.close();
        }
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