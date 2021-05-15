package com.example.bdconservatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class InformacionUsuario extends AppCompatActivity implements View.OnClickListener {
    private EditText et_nombre, et_pass, et_instrumento, et_documento, et_apellido;
    private Button bt1,bt2,bt3,bt4,bt5;
    private ImageButton ib;
    String nombreUsuario;
    String nombre,apellido,instrumento,pass;
    int documento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_usuario);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_icono);

        et_nombre = (EditText)findViewById(R.id.txt_nombreRegistro);
        et_pass = (EditText)findViewById(R.id.txt_passRegistro);
        et_instrumento = (EditText)findViewById(R.id.txt_instrumentoRegistro);
        et_apellido = (EditText)findViewById(R.id.txt_apellido);
        et_documento = (EditText)findViewById(R.id.txt_documento);

        bt1 = (Button)findViewById(R.id.btn_editar1);
        bt2 = (Button)findViewById(R.id.btn_editar2);
        bt3 = (Button)findViewById(R.id.btn_editar3);
        bt4 = (Button)findViewById(R.id.btn_editar4);
        bt5 = (Button)findViewById(R.id.btn_editar5);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);

        ib = (ImageButton)findViewById(R.id.ib_editarFoto);
        ib.setOnClickListener(this);

        nombreUsuario = getIntent().getStringExtra("nombre");
        et_nombre.setText(nombreUsuario);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("SELECT nombre, pass, apellido, instrumento FROM usuarios WHERE nombre = " + "'"+ nombreUsuario + "'", null);
        if(fila.moveToFirst()){
            et_nombre.setText(fila.getString(0));
            et_pass.setText(fila.getString(1));
            et_apellido.setText(fila.getString(2));
            et_instrumento.setText(fila.getString(3));
        }else{
            Toast.makeText(this, "Error en mostrar datos existentes", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //agrego las modificaciones
            case R.id.btn_editar1:
                //nombre
                nombre = et_nombre.getText().toString();
                Toast.makeText(this, "Se ha editado el Nombre correctamente", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_editar2:
                //apellido
                apellido = et_apellido.getText().toString();
                Toast.makeText(this, "Se ha editado el Apellido correctamente", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_editar3:
                //doc
                et_documento.setText("");
                break;
            case R.id.btn_editar4:
                //pass
                pass = et_pass.getText().toString();
                Toast.makeText(this, "Se ha editado la Contraseña correctamente", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_editar5:
                //instr
                instrumento = et_instrumento.getText().toString();
                Toast.makeText(this, "Se ha editado el Instrumento correctamente", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_editarFoto:
                //foto
                break;
        }
    }
    public void GuardarCambios(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("nombre",nombre);
        registro.put("apellido", apellido);
        //registro.put("documento",documento);
        registro.put("pass", pass);
        registro.put("instrumento", instrumento);

        int cantidad = BaseDeDatos.update("usuarios", registro,"nombre ="+ "'" + nombreUsuario + "'", null);
        BaseDeDatos.close();
        if(cantidad == 1){
            Toast.makeText(this, "Cambios guardados", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Alumnos.class);
            intent.putExtra("nombre", nombreUsuario);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Error al modificar datos", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, Alumnos.class);
        intent.putExtra("nombre",nombreUsuario);
        startActivity(intent);
        finish();
    }
}