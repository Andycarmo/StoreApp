package com.andycarmo.storeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import modelo.Repuesto;

public class almacen extends AppCompatActivity {

    private RecyclerView rvRepuestolist;
    TextView tvAlmac;
    EditText edtxCeco, edtxUbicacion, edtxDescripcion;
    Button btnRegistrar;
    FirebaseFirestore mFirestore;

    DatabaseReference DatabaseReference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRowC = DatabaseReference.child("txt");

    ArrayList <Repuesto> respuestos = new ArrayList<>();

    Repuesto r1 = new Repuesto(85370590, "ACOPOS P3 SERVO DRIVE 3X 200-480 VAC, 2", "2-C-0");
    Repuesto r2 = new Repuesto(85370591, "ACOPOS P3 SERVO DRIVE 3X 200-480 VAC, 4", "2-C-0");
    Repuesto r3 = new Repuesto(85370598, "I/O LINK ACTUATOR CABLE LENGTH 5 METER", "2-G-0");
    Repuesto r4 = new Repuesto(85290423, "T"+" DESCARGUE TOLVA SIST/DOSIF 2"+" X1"+" MESP","6-A-7");
    Repuesto r5 = new Repuesto(85290424, "Y"+" DESCARGUE SIST/DOSIF 1X1/2"+" MESPACK", "6-A-6");
    Repuesto r6 = new Repuesto(1000358881, "[146653]AMORT.PULS.BALAO 2.5G-2NPT210KG", "ESTIBA");
    Repuesto r7 = new Repuesto(85359617, "1G222-4452038CE-CIERRE PROLAC SILICIO/SI", "9-B-6");
    Repuesto r8 = new Repuesto(85359614, "1G327-1452050 CIERRE SLR 3A GRAF/SILICIO", "9-B-6");
    Repuesto r9 = new Repuesto(85359615, "1G327-1478050-CIERRE SLR 3A GRAF/SILICIO", "9-B-6");
    Repuesto r10 = new Repuesto(85280077, "3FV Adapt-Roytronic Fittings-PVDF- M ROY", "9-F-5");
    Repuesto r11 = new Repuesto(85293927, "CORREA DENTADA 475 5MGT GATES BOSH$1", "7-C-3");


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
        mFirestore = FirebaseFirestore.getInstance();

        //>>>>>  Recycler View  <<<< ///
        rvRepuestolist = findViewById(R.id.rvAlmacen);

        respuestos.add(r1);
        respuestos.add(r2);
        respuestos.add(r3);
        respuestos.add(r4);
        respuestos.add(r5);
        respuestos.add(r6);
        respuestos.add(r7);
        respuestos.add(r8);
        respuestos.add(r9);
        respuestos.add(r10);

        LinearLayoutManager LLMRepuestos = new LinearLayoutManager(this);
        rvRepuestolist.setLayoutManager(LLMRepuestos);
        rvRepuestolist.setAdapter(new AdapterRepuestos());


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

        mFirestore.collection("Repuestos").document().set(repuesto);

    }

    public void volver(View view){
        Intent j = new Intent(this, Jabones.class);
        startActivity(j);
    }










    @Override
    protected void onStart() {
        super.onStart();

        myRowC.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String texto = Objects.requireNonNull(snapshot.getValue().toString());
                tvAlmac.setText(texto);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    class AdapterRepuestos extends RecyclerView.Adapter <AdapterRepuestos.AdaptadorRepuestosHolder> {
        @NonNull
        @Override
        public AdaptadorRepuestosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapterRepuestosHolder(getLayoutInflater().inflate(R.layout.itemrepuestos,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterRepuestos.AdaptadorRepuestosHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}