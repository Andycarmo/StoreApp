package com.andycarmo.storeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.protobuf.Empty;

import java.util.HashMap;
import java.util.Map;

public class newPump extends AppCompatActivity {

    private EditText edtNombre, edtTipo, edtMarca, edtDocumento;
    private Button btnRegistrar, btnEditar, btnEliminar, btnConsultar;

    FirebaseFirestore firestore;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pump);

        edtDocumento = findViewById(R.id.etCodigo);
        edtNombre = findViewById(R.id.etNombre);
        edtTipo = findViewById(R.id.etTipo);
        edtMarca = findViewById(R.id.etMarca);
        btnRegistrar = findViewById(R.id.btnAgregar);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnConsultar = findViewById(R.id.btnConsultar);

        firestore = FirebaseFirestore.getInstance();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtNombre.isClickable()){
                    Toast.makeText(newPump.this, "Nueva Bomba Agregada !!!", Toast.LENGTH_SHORT).show();
                    registrar();
                }else{
                    Toast.makeText(newPump.this, "Ingresar un nombre Valido :) !", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Toast.makeText(newPump.this, "Bba Editada con exito !!!", Toast.LENGTH_SHORT).show();
                editar();
        }
    });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(newPump.this, "Bba eliminada !!!", Toast.LENGTH_SHORT).show();
                eliminar();
            }
        });
}
    public void registrar() {
        Map<String, Object> bomba = new HashMap<>();

        bomba.put("Nombre", edtNombre.getText().toString());
        bomba.put("Tipo", edtTipo.getText().toString());
        bomba.put("Marca", edtMarca.getText().toString());

        firestore.collection("Bombas").document(edtDocumento.getText().toString()).set(bomba);

        clean();

    }
    public void editar() {
        Map<String, Object> bomba = new HashMap<>();

        bomba.put("Nombre", edtNombre.getText().toString());
        bomba.put("Tipo", edtTipo.getText().toString());
        bomba.put("Marca", edtMarca.getText().toString());

        firestore.collection("Bombas").document(edtDocumento.getText().toString()).update(bomba);

    }

    public void eliminar() {

        firestore.collection("Bombas").document(edtDocumento.getText().toString()).delete();

    }

/**
     //btnConsultar.setOnClickListener(new View.OnClickListener() {
     //  @Override
     //  public void onClick(View view) {
     //consultar();
     //}
     //});
     }**/

    public void clean(){
        edtDocumento.setText("");
        edtNombre.setText("");
        edtTipo.setText("");
        edtMarca.setText("");
    }

}