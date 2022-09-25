package com.andycarmo.storeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class almacen extends AppCompatActivity {

    TextView tvAlmac;
    EditText edtxCeco, edtxUbicacion, edtxDescripcion;
    Button btnRegistrar;
    //FirebaseFirestore mFirestore;

    //DatabaseReference DatabaseReference = FirebaseDatabase.getInstance().getReference();
    //DatabaseReference myRowC = DatabaseReference.child("txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen);

        //>>>>>  TextView para el Realtime Database  <<<< ///
        tvAlmac = findViewById(R.id.tvAlmacen);
        edtxCeco = findViewById(R.id.etCeCo);
        edtxUbicacion= findViewById(R.id.etUbicacion);
        edtxDescripcion = findViewById(R.id.etDescripcion);
        btnRegistrar = findViewById(R.id.btnRegistrar);
      //  mFirestore = FirebaseFirestore.getInstance();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(almacen.this, "Repuesto Registrado!!!", Toast.LENGTH_LONG).show();
                registrar();
            }
        });

    }

    public void registrar() {
        Map<String, Object> repuesto = new HashMap<>();

        repuesto.put("CeCo",edtxCeco.getText().toString());
        repuesto.put("Ubicación", edtxUbicacion.getText().toString());
        repuesto.put("Descripción", edtxDescripcion.getText().toString());

      //  mFirestore.collection("Repuestos").document().set(repuesto);

    }

    public void volver(View view){
        Intent j = new Intent(this, Jabones.class);
        startActivity(j);
    }










  //  @Override
   // protected void onStart() {
   //     super.onStart();

        //myRowC.addValueEventListener(new ValueEventListener() {
         //   @Override
        //    public void onDataChange(@NonNull DataSnapshot snapshot) {
        //        String texto = Objects.requireNonNull(snapshot.getValue().toString());
        //        tvAlmac.setText(texto);
        //    }

        //    @Override
        //    public void onCancelled(@NonNull DatabaseError error) {

            }
       // });

   // }



//}